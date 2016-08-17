package info.magnolia.module.businessCanvas.view;

import info.magnolia.context.MgnlContext;

import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;

import elemental.json.JsonArray;

@JavaScript({ "js/canvas.js", "js/canvas_connector.js" })
public class BusinessCanvasJs extends AbstractJavaScriptComponent {

    private static final long serialVersionUID = 1L;
    private String pathToCanvas = "businessCanvas/users/";

    public BusinessCanvasJs() {
        init();
        // Callback from the canvas component
        addFunction("getCanvas", new JavaScriptFunction() {
            private static final long serialVersionUID = 1L;

            @Override
            public void call(JsonArray arguments) {
                Session jcrSession;
                try {
                    jcrSession = MgnlContext.getInstance().getJCRSession("businessCanvas");
                    String userName = MgnlContext.getUser().getName();
                    String path = pathToCanvas + userName;
                    try {
                        Node node = jcrSession.getNode("/" + path);
                        node.setProperty(arguments.getString(1), arguments.getString(0));
                        getState().currentValue = arguments.getString(1) + " => " + arguments.getString(0);
                        jcrSession.save();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        });
    }

    @Override
    public BusinessCanvasState getState() {
        return (BusinessCanvasState) super.getState();
    }

    public void setName(String name) {
        getState().name = name;
    }

    public void setTitle(String title) {
        getState().title = title;
    }

    /**
     * load the available data into the canvas
     */
    public void init() {
        try {

            Session jcrSession = MgnlContext.getInstance().getJCRSession("businessCanvas");
            String userName = MgnlContext.getUser().getName();
            if (!jcrSession.nodeExists("/" + pathToCanvas + userName)) {
                createUserFolder(jcrSession);
            }

            Node node = jcrSession.getNode("/" + pathToCanvas + userName);
            PropertyIterator properties = node.getProperties();
            while (properties.hasNext()) {
                Property prop = (Property) properties.next();
                String name = prop.getName();

                if (name.equals(BusinessCanvasState.CHANNELS)) {
                    getState().channels = prop.getValue().getString();
                }

                if (name.equals(BusinessCanvasState.COSTSTRUCTURE)) {
                    getState().costStructure = prop.getValue().getString();
                }

                if (name.equals(BusinessCanvasState.CUSTOMERRELATIONSHIP)) {
                    getState().customerRelationship = prop.getValue().getString();
                }

                if (name.equals(BusinessCanvasState.CUSTOMERSEGMENTS)) {
                    getState().customerSegments = prop.getValue().getString();
                }

                if (name.equals(BusinessCanvasState.KEYACTIVITIES)) {
                    getState().setKeyActivities(prop.getValue().getString());
                }

                if (name.equals(BusinessCanvasState.KEYPARTNERS)) {
                    getState().keyPartners = prop.getValue().getString();
                }

                if (name.equals(BusinessCanvasState.KEYRESOURCES)) {
                    getState().keyResources = prop.getValue().getString();
                }

                if (name.equals(BusinessCanvasState.REVENUESTREAMS)) {
                    getState().revenueStreams = prop.getValue().getString();
                }

                if (name.equals(BusinessCanvasState.VALUEPROPOSITION)) {
                    getState().valueProposition = prop.getValue().getString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Resets the business canvas
     */
    public void resetCanvas() {
        getState().channels = " ";
        getState().costStructure = " ";
        getState().customerRelationship = " ";
        getState().customerSegments = " ";
        getState().setKeyActivities(" ");
        getState().keyPartners = " ";
        getState().keyResources = " ";
        getState().revenueStreams = " ";
        getState().valueProposition = " ";

        Session jcrSession;
        try {
            jcrSession = MgnlContext.getInstance().getJCRSession("businessCanvas");
            String userName = MgnlContext.getUser().getName();

            if (!jcrSession.nodeExists("/" + pathToCanvas + userName)) {
                createUserFolder(jcrSession);
            }
            Node node = jcrSession.getNode("/" + pathToCanvas + userName);
            PropertyIterator properties = node.getProperties();
            // Don't do this in a real project
            while (properties.hasNext()) {
                Property prop = (Property) properties.next();
                try {
                    prop.remove();
                } catch (Exception e) {
                }
                jcrSession.save();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Create folders
     *
     * @param session
     * @throws RepositoryException
     */
    public void initWorkSpace(Session session) throws RepositoryException {
        if (!session.nodeExists("/businessCanvas")) {
            session.getRootNode().addNode("businessCanvas");
        }

        if (!session.nodeExists("/businessCanvas/users")) {
            session.getRootNode().addNode("businessCanvas/users");
        }

        session.save();
    }

    /**
     * Create the used in the BusinessCanvas workspace
     *
     * @param session
     * @throws RepositoryException
     */
    private void createUserFolder(Session session) throws RepositoryException {
        String userName = MgnlContext.getUser().getName();

        if (!session.nodeExists("/businessCanvas/users/" + userName)) {
            session.getRootNode().addNode("businessCanvas/users/" + userName);
        }
        session.save();
    }

}
