package com.globant.magnolia.resources;

import javax.inject.Inject;
import javax.jcr.RepositoryException;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponses;

import info.magnolia.rest.AbstractEndpoint;
import info.magnolia.rest.service.node.definition.NodeEndpointDefinition;
import info.magnolia.rest.service.node.v1.RepositoryNode;

@Api(value = "/search/v1", description = "Search servlet")
/*     */ @Path("/search/v1")
public class SearchServiceEndpoint<D extends NodeEndpointDefinition> extends AbstractEndpoint<D> {

    public static final Logger LOGGER = LoggerFactory.getLogger(SearchServiceEndpoint.class);
    
    @Inject
    private com.globant.magnolia.services.SearchService searchService;

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Inject
    public SearchServiceEndpoint(D endpointDefinition) {
        super(endpointDefinition);
    }

    @GET
    @Produces({ "application/json" })
    @ApiOperation(value = "Get a node", notes = "Returns a node from the specified workspace and path")
    @ApiResponses({
            @com.wordnik.swagger.annotations.ApiResponse(code = 200, message = "OK", response = RepositoryNode.class),
            @com.wordnik.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
            @com.wordnik.swagger.annotations.ApiResponse(code = 404, message = "Node not found"),
            @com.wordnik.swagger.annotations.ApiResponse(code = 500, message = "Error occurred") })
    public Response search(@QueryParam("query") @DefaultValue("") String query)
            throws RepositoryException {
        JSONArray result = searchService.search(query);
        return Response.ok(result.toString()).build();
    }

}
