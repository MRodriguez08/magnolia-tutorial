package com.globant.magnolia.services.impl;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.impl.HttpSolrClient;

import com.globant.magnolia.services.SolrClientFactory;

public class SolrClientFactoryImpl implements SolrClientFactory {

    @Override
    public SolrClient getClient() {
    	SolrClient solrClient = new HttpSolrClient("http://localhost:8983/solr/magnoliatraining");
    	return solrClient;
    }

}
