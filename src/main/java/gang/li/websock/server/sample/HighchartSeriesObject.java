package gang.li.websock.server.sample;

import java.util.List;

/**
 * This is a pojo which is used to mapping to front-end highchart js series
 * elements. It can be used to generate json object of series of highchart chart
 * options using gson, so to improve ajax development of highchart js.
 * 
 * 
 * @author gli@redhat.com
 * 
 */
public class HighchartSeriesObject {
    public static final String TYPE_COLUMN = "column";
    public static final String TYPE_LINE = "line";
    public static final String TYPE_SPLINE = "spline";
    
    public static final String DASHSTYLE_LONGDASH = "longdash";

    // id of the series
    private String id = null;

    public static final Integer X_AXIS_FIRST = 0;

    public static final Integer X_AXIS_SECOND = 1;

    public static final Integer Y_AXIS_FIRST = 0;

    public static final Integer Y_AXIS_SECOND = 1;

    // name of the series
    private String name = null;

    // type of this series, e.g, line, spline, column. Null to make it default.
    private String type = null;

    // data of the series
    @SuppressWarnings("rawtypes")
    private List data;

    // color of the series. If it is null, means color is auto.
    private String color = null;

    // xAxis of the series, used to specify which xAxis this series is for. If
    // it is null, equals default which is 0;
    private Integer xAxis = null;

    // yAxis of the series, used to specify which yAxis this series is for. If
    // it is null, equals default which is 0;
    private Integer yAxis = null;

    // showInLegend of the series, used to specify if this series needs to show
    // the legend. If it is null, equals default which is true.
    private Boolean showInLegend = null;

    // stack of the series, used to specify which stack this series if for.
    // This option allows grouping series in a stacked chart. The stack option
    // can be a string or a number or anything else, as long as the grouped
    // series' stack
    // options match each other.
    private String stack = null;

    private String dashStyle = null;

    public HighchartSeriesObject() {
	// do nothing
    }

    public HighchartSeriesObject(String name, String type,
	    @SuppressWarnings("rawtypes") List data, String color,
	    Integer xAxis, Integer yAxis, Boolean showInLegend) {
	this.name = name;
	this.type = type;
	this.data = data;
	this.color = color;
	this.xAxis = xAxis;
	this.yAxis = yAxis;
	this.showInLegend = showInLegend;
	// id = name alternatively use setId()
	this.id = name;
    }

    public HighchartSeriesObject(String name, String type,
	    @SuppressWarnings("rawtypes") List data, String color,
	    Integer xAxis, Integer yAxis, Boolean showInLegend, String stack) {
	this(name, type, data, color, xAxis, yAxis, showInLegend);
	this.stack = stack;
    }

    public String getId() {
	return id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getType() {
	return type;
    }

    public void setType(String type) {
	this.type = type;
    }

    @SuppressWarnings("rawtypes")
    public List getData() {
	return data;
    }

    public void setData(@SuppressWarnings("rawtypes") List data) {
	this.data = data;
    }

    public String getColor() {
	return color;
    }

    public void setColor(String color) {
	this.color = color;
    }

    public Integer getxAxis() {
	return xAxis;
    }

    public void setxAxis(Integer xAxis) {
	this.xAxis = xAxis;
    }

    public Integer getyAxis() {
	return yAxis;
    }

    public void setyAxis(Integer yAxis) {
	this.yAxis = yAxis;
    }

    public Boolean getShowInLegend() {
	return showInLegend;
    }

    public void setShowInLegend(Boolean showInLegend) {
	this.showInLegend = showInLegend;
    }

    public String getStack() {
	return stack;
    }

    public void setStack(String stack) {
	this.stack = stack;
    }

    public String getDashStyle() {
	return dashStyle;
    }

    public void setDashStyle(String dashStyle) {
	this.dashStyle = dashStyle;
    }

}