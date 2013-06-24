/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gang.li.websock.rs.services.todo;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gli
 */
@XmlRootElement(name = "todo")
public class Todo {

    private String id;
    private String content;
    private Boolean done;

    @XmlElement
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @XmlElement
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @XmlElement
    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}
