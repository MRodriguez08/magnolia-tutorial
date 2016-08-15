package com.globant.magnolia.rest;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;

import com.google.gson.JsonObject;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiResponses;

import info.magnolia.context.MgnlContext;
import info.magnolia.rest.AbstractEndpoint;
import info.magnolia.rest.service.node.definition.NodeEndpointDefinition;
import info.magnolia.rest.service.node.v1.RepositoryNode;

@Api(value = "/firstmagnoliarest/v1", description = "My first magnolia rest ")
/*     */ @Path("/firstmagnoliarest/v1")
public class MyFirstServiceEndpoint<D extends NodeEndpointDefinition> extends AbstractEndpoint<D> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	public MyFirstServiceEndpoint(D endpointDefinition) {
		super(endpointDefinition);
	}

	@GET
	@Path("/hello")
	@Produces({ "application/json", "application/xml" })
	@ApiOperation(value = "Get a node", notes = "Returns a node from the specified workspace and path")
	@ApiResponses({
			@com.wordnik.swagger.annotations.ApiResponse(code = 200, message = "OK", response = RepositoryNode.class),
			@com.wordnik.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
			@com.wordnik.swagger.annotations.ApiResponse(code = 404, message = "Node not found"),
			@com.wordnik.swagger.annotations.ApiResponse(code = 500, message = "Error occurred") })
	public Response readNode(@QueryParam("name") @DefaultValue("anonymous") String userName)
			throws RepositoryException {
		String absPath = StringUtils.defaultIfEmpty("", "/");
		Session session = MgnlContext.getJCRSession("");
		if (!(session.nodeExists(absPath))) {
			return Response.status(Response.Status.NOT_FOUND).build();
		}

		Node node = session.getNode(absPath);

		JsonObject response = new JsonObject();
		response.addProperty("message", " hello " + userName + " !!");
		response.addProperty("statusCode", 200);

		return Response.ok(response).build();
	}

}
