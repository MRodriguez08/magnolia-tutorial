package info.magnolia.module.businessCanvas.view.jsCanvas;

import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;

import elemental.json.JsonArray;

/**
 * Created with IntelliJ IDEA.
 * User: schulteja
 * Date: 20/02/14
 * Time: 16:03
 * To change this template use File | Settings | File Templates.
 */
public class BusinessCanvas extends AbstractJavaScriptComponent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BusinessCanvas(){
        //add a function to get the latest data
        addFunction("peekData", new JavaScriptFunction() {
			/**
			 * 
			 */
            private static final long serialVersionUID = 1L;

            @Override
            public void call(JsonArray arguments) {
				// TODO Auto-generated method stub
				
			}
        });
    }
 }
