package com.globant.magnolia.rest;

import java.util.Date;

import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.globant.magnolia.rest.dto.HelloDTO;
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

    private static final String TUTORIAL_WORKSPACE = "magnoliaTutorialTemplateModule";

    public static final Logger LOGGER = LoggerFactory.getLogger(MyFirstServiceEndpoint.class);

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Inject
    public MyFirstServiceEndpoint(D endpointDefinition) {
        super(endpointDefinition);
        try {
            Session session = MgnlContext.getJCRSession(TUTORIAL_WORKSPACE);
            String workspacePath = "helloservice";
            if (!(session.nodeExists("/" + workspacePath))) {
                session.getRootNode().addNode(workspacePath);
                session.save();
            }
        } catch (Exception e) {
            LOGGER.error("unable to create workspace", e);
        }

    }

    @GET
    @Path("/hello")
    @Produces({ "application/json" })
    @ApiOperation(value = "Get a node", notes = "Returns a node from the specified workspace and path")
    @ApiResponses({
            @com.wordnik.swagger.annotations.ApiResponse(code = 200, message = "OK", response = RepositoryNode.class),
            @com.wordnik.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
            @com.wordnik.swagger.annotations.ApiResponse(code = 404, message = "Node not found"),
            @com.wordnik.swagger.annotations.ApiResponse(code = 500, message = "Error occurred") })
    public Response getGreeting(@QueryParam("name") @DefaultValue("anonymous") String userName)
            throws RepositoryException {
        JsonObject response = new JsonObject();
        response.addProperty("message", " hello " + userName + " !!");
        response.addProperty("statusCode", 200);

        return Response.ok(response.toString()).build();
    }

    @POST
    @Path("/hello")
    @Produces({ "application/json" })
    @Consumes({ "application/json" })
    @ApiOperation(value = "Get a node", notes = "Returns a node from the specified workspace and path")
    @ApiResponses({
            @com.wordnik.swagger.annotations.ApiResponse(code = 200, message = "OK", response = RepositoryNode.class),
            @com.wordnik.swagger.annotations.ApiResponse(code = 401, message = "Unauthorized"),
            @com.wordnik.swagger.annotations.ApiResponse(code = 404, message = "Node not found"),
            @com.wordnik.swagger.annotations.ApiResponse(code = 500, message = "Error occurred") })
    public Response saveGreetingNode(HelloDTO data) throws RepositoryException {
        Session session = MgnlContext.getJCRSession(TUTORIAL_WORKSPACE);
        String tmpNodeRelPath = "helloservice/" + data.getUserName();
        Node tmpNode = null;
        if (!(session.nodeExists("/" + tmpNodeRelPath))) {
            tmpNode = session.getRootNode().addNode(tmpNodeRelPath);
        } else {
            tmpNode = session.getNode(tmpNodeRelPath);
        }

        tmpNode.setProperty("userName", data.getUserName());
        tmpNode.setProperty("mood", data.getMood());
        tmpNode.setProperty("timestamp", new Date().getTime());

        session.save();

        return Response.ok(data).build();
    }

}
