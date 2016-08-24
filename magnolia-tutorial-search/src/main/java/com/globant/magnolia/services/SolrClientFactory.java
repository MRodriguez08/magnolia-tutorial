package com.globant.magnolia.services;

import org.apache.solr.client.solrj.SolrClient;

public interface SolrClientFactory {
    
    public SolrClient getClient();

}
