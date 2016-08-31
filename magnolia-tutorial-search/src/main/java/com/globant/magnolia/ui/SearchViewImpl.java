package com.globant.magnolia.ui;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.inject.Inject;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.vaadin.ui.Component;
import com.vaadin.ui.CustomLayout;

/**
 * Created with IntelliJ IDEA. User: schulteja Date: 20/02/14 Time: 11:30 To
 * change this template use File | Settings | File Templates.
 */
public class SearchViewImpl implements SearchView {
    /**
     *
     */
    private static final long serialVersionUID = 1442854216593824850L;

    public static final Logger LOGGER = LoggerFactory.getLogger(SearchViewImpl.class);

    @Inject
    private com.globant.magnolia.services.SearchService searchService;

    /**
     *
     */
    private CustomLayout layout;
    private SearchJs searchJs;

    public SearchViewImpl() {
        searchJs = new SearchJs();
        try {
            // Load the HTML. Dont to this in a real app. This was just done to
            // keep things simple
            InputStream in = this.getClass().getClassLoader()
                    .getResourceAsStream("com/globant/magnolia/ui/magnolia-tutorial-search/app/html/search.html");
            byte[] bytes = IOUtils.toByteArray(in);
            layout = new CustomLayout(new ByteArrayInputStream(bytes));
            layout.setWidth("100%");
            layout.setHeight("1240px");
            layout.addComponent(searchJs);

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }

    public com.globant.magnolia.services.SearchService getSearchService() {
        return searchService;
    }

    public void setSearchService(com.globant.magnolia.services.SearchService searchService) {
        this.searchService = searchService;
    }

    @Override
    public Component asVaadinComponent() {
        return layout;
    }
}
