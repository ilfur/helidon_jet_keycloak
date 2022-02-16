package io.helidon.dbstat;

import io.helidon.microprofile.cors.CrossOrigin;
import java.util.Collections;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonBuilderFactory;
import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.HttpMethod;
import javax.ws.rs.OPTIONS;

import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.annotation.security.RolesAllowed;

/**
 * A simple JAX-RS resource to greet you. Examples:
 *
 * Get default greeting message: curl -X GET http://localhost:8080/greet
 *
 * Get greeting message for Joe: curl -X GET http://localhost:8080/greet/Joe
 *
 * Change greeting curl -X PUT -H "Content-Type: application/json" -d
 * '{"greeting" : "Howdy"}' http://localhost:8080/greet/greeting
 *
 * The message is returned as a JSON object.
 */
@Path("/hello")
@RequestScoped
public class HelloResource {

    private static final JsonBuilderFactory JSON = Json.createBuilderFactory(Collections.emptyMap());
    Logger logger = Logger.getLogger(this.getClass().getName());

    /**
     * The greeting message provider.
     */

    /**
     * Return a worldly greeting message.
     *
     * @return {@link JsonObject}
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("appuserrole")
    public Response getDefaultMessage(@HeaderParam("Host") String host) {
        logger.info("Incoming from host " + host + " ! ");
        JsonObject retJ = JSON.createObjectBuilder()
                .add("hello", "world")
                .build();
        return Response
                .status(200)
                .entity(retJ)
                .build();
    }

    @OPTIONS
    @CrossOrigin(
            //value = {"http://localhost:8000","http://127.0.0.1:8000"},
            //allowHeaders = {"Accept","Accept-Encoding"},
            value = {"*"},
            allowMethods = {HttpMethod.GET})
    public void optionsForGetDefaultMessage() {}

    
    private JsonObject createResponse(String who) {
        String msg = String.format("%s %s!", "yada", who);

        return JSON.createObjectBuilder()
                .add("message", msg)
                .build();
    }
}
