/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gang.li.websock.server.sample;

import com.google.gson.Gson;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.concurrent.CopyOnWriteArraySet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import org.apache.catalina.websocket.MessageInbound;
import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;
import org.apache.catalina.websocket.WsOutbound;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 *
 * @author gli
 */
@WebServlet(urlPatterns = "/ChartSchedule", name = "wsChartResponseScheduleWebSockServlet")
public class ChartResponseScheduleWebSockServlet extends WebSocketServlet {

    private static final long serialVersionUID = 1L;
    private final Set<ChartResponseScheduleWebSockServlet.ChartOptionsMessageInbound> connections =
            new CopyOnWriteArraySet<>();

    @Override
    protected StreamInbound createWebSocketInbound(String subProtocol,
            HttpServletRequest request) {
        return new ChartResponseScheduleWebSockServlet.ChartOptionsMessageInbound();
    }

    private final class ChartOptionsMessageInbound extends MessageInbound {

        private ChartOptionsMessageInbound() {
        }

        @Override
        protected void onOpen(WsOutbound outbound) {
            connections.add(this);
            broadcast("{\"pingMessage\":\"a new client has connected in!\"}");
        }

        @Override
        protected void onClose(int status) {
            connections.remove(this);
            broadcast("{\"pingMessage\":\"a client exited!\"}");
        }

        @Override
        protected void onBinaryMessage(ByteBuffer message) throws IOException {
            throw new UnsupportedOperationException(
                    "Binary message not supported.");
        }

        @Override
        protected void onTextMessage(CharBuffer message) throws IOException {
            // Never trust the client

            String messageBody = message.toString();
            System.out.println(messageBody);
            String[] splitedMessage = messageBody.split(",");
            List<Integer> datas = new ArrayList<Integer>(splitedMessage.length);
            for (String s : splitedMessage) {
                datas.add(Integer.parseInt(s.trim()));
            }
            HighchartSeriesObject chart = new HighchartSeriesObject();
            chart.setName("Increment Count");
            chart.setType(HighchartSeriesObject.TYPE_LINE);
            chart.setColor("red");
            chart.setData(datas);
            Map<String, Object> jsonMap = new HashMap<String, Object>();
            List<HighchartSeriesObject> series = new ArrayList<HighchartSeriesObject>();
            series.add(chart);
            jsonMap.put("series", series);
            broadcast(new Gson().toJson(jsonMap));
        }

        private void broadcast(String message) {
            for (ChartResponseScheduleWebSockServlet.ChartOptionsMessageInbound connection : connections) {
                try {
                    CharBuffer buffer = CharBuffer.wrap(message);
                    connection.getWsOutbound().writeTextMessage(buffer);
                } catch (IOException ignore) {
                    // Ignore
                }
            }
        }
    }

    private class ChartJob implements Job {

        @SuppressWarnings("deprecation")
        public void execute(JobExecutionContext arg0) throws JobExecutionException {
            
        }
    }
}
