package com.ildo.rest.mars;

import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

@Path("mars")
@Consumes("text/plain")
@Produces("text/plain")
@Stateless
public class MarsService {

    @Path("/{commands}")
    @GET
    @POST
    public Response move(@Context final UriInfo ui,
                                  @DefaultValue("")
                                  @PathParam("commands") String commands) {

        MarsValidator marsValidator = new MarsValidator(commands);

        if ( !marsValidator.isCommandListValid() || !marsValidator.isFuturePositionValid() )
            return Response.status(400).build();

        Robot robot = new Robot();
        if (robot.executeCommands(marsValidator.getCommandList()))
            return Response.ok().entity( robot.getPosition().toString() ).build();
        else
            return Response.status(400).entity( "Robot Execution Error" ).build();

    }

}
