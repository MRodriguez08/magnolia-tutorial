package com.globant.magnolia.ui;

import com.vaadin.shared.ui.JavaScriptComponentState;

/**
 * State object to transfer data between client and backend
 * 
 * @author schulteja
 */
public class SearchState extends JavaScriptComponentState {

    private static final long serialVersionUID = 1L;
    public String value;

    public void setValue(String value) {
        this.value = value;
    }

    public String searchResults;

    public static String SEARCH_RESULTS = "searchResults";

}
