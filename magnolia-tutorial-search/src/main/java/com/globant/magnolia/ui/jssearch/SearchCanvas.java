package com.globant.magnolia.ui.jssearch;

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
public class SearchCanvas extends AbstractJavaScriptComponent {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SearchCanvas(){
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
