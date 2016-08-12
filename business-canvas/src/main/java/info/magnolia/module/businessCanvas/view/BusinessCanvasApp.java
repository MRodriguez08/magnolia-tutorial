package info.magnolia.module.businessCanvas.view;

import info.magnolia.ui.api.app.SubAppContext;
import info.magnolia.ui.framework.app.BaseSubApp;

import com.google.inject.Inject;


/**
 * Business canvas sub app
 * 
 * @author schulteja
 */
public class BusinessCanvasApp extends BaseSubApp {


    @Inject
    public BusinessCanvasApp(final SubAppContext subAppContext, final BusinessCanvasView view) {
        super(subAppContext, view);
    }

    @Override
    public BusinessCanvasView getView() {
        return (BusinessCanvasView) super.getView();
    }


}
