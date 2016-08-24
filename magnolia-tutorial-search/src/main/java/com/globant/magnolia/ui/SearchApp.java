package com.globant.magnolia.ui;

import info.magnolia.ui.api.app.SubAppContext;
import info.magnolia.ui.framework.app.BaseSubApp;

import com.google.inject.Inject;


/**
 * Business canvas sub app
 * 
 * @author schulteja
 */
public class SearchApp extends BaseSubApp {


    @Inject
    public SearchApp(final SubAppContext subAppContext, final SearchView view) {
        super(subAppContext, view);
    }

    @Override
    public SearchView getView() {
        return (SearchView) super.getView();
    }


}
