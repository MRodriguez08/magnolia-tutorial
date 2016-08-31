package com.globant.magnolia.ui;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.annotations.JavaScript;
import com.vaadin.ui.AbstractJavaScriptComponent;
import com.vaadin.ui.JavaScriptFunction;

import elemental.json.JsonArray;
import info.magnolia.objectfactory.Components;

@JavaScript({ 
    "magnolia-tutorial-search/view/js/search.js", 
    "magnolia-tutorial-search/view/js/search_connector.js" 
})
public class SearchJs extends AbstractJavaScriptComponent {

    private static final long serialVersionUID = 1L;
    public static final Logger LOGGER = LoggerFactory.getLogger(SearchJs.class);
    
    private com.globant.magnolia.services.SearchService searchService;

    public SearchJs() {
        init();
        // Callback from the canvas component
        addFunction("search", new JavaScriptFunction() {
            private static final long serialVersionUID = 1L;

            @Override
            public void call(JsonArray arguments) {
                try {
                    searchService = Components.getComponent(com.globant.magnolia.services.SearchService.class);
                    JSONArray result = searchService.search(arguments.getString(0));
                    getState().searchResults = result.toString();
                    LOGGER.debug(arguments.getString(1) + " => " + arguments.getString(0));
                } catch (Exception ex) {
                    LOGGER.error(ex.getMessage(), ex);
                }
            }

        });
    }

    @Override
    public SearchState getState() {
        return (SearchState) super.getState();
    }

    /**
     * load the available data into the canvas
     */
    public void init() {
        try {

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

}
