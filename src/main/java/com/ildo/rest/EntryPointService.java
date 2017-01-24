package com.ildo.rest;

import com.ildo.rest.mars.MarsService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.ArrayList;

@Path("/")
public class EntryPointService {

    @Path("/")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response listServices(@Context UriInfo ui) {
        URI baseURI = ui.getBaseUri();

        ArrayList<GenericReference> services = new ArrayList<GenericReference>();

        services.add(new GenericReference(UriBuilder.fromUri(baseURI)
                .path(MarsService.class).build().getRawPath()
                , "mars"));

        return Response.ok(services).build();
    }

}
