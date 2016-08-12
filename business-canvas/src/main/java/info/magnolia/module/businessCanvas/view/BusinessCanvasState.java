package info.magnolia.module.businessCanvas.view;

import com.vaadin.shared.ui.JavaScriptComponentState;

/**
 * State object to transfer data between client and backend
 * 
 * @author schulteja
 */
public class BusinessCanvasState extends JavaScriptComponentState{

    private static final long serialVersionUID = 1L;
    public String fieldValue;
	public String name;
	public String title;
	public String value;

    public void setValue(String value) {
		this.value = value;
	}

	public String keyPartners;
	private String keyActivities;
	public String valueProposition;
	public String customerRelationship;
	public String customerSegments;
	public String keyResources;
	public String channels;
	public String costStructure;
	public String revenueStreams;
	public String currentValue;

	public static String KEYPARTNERS = "keyPartners";
	public static String KEYACTIVITIES = "keyActivities";
	public static String VALUEPROPOSITION = "valueProposition";
	public static String CUSTOMERRELATIONSHIP = "customerRelationship";
	public static String CUSTOMERSEGMENTS = "customerSegments";
	public static String KEYRESOURCES = "keyResources";
	public static String CHANNELS = "channels";
	public static String COSTSTRUCTURE = "costStructure";
	public static String REVENUESTREAMS = "revenueStreams";
	public static String CURRENT_VALUE = "currentValue";

	public String getKeyActivities() {
		return keyActivities;
	}
	
	public void setKeyActivities(String keyActivities) {
		this.keyActivities = keyActivities;
	}

}
