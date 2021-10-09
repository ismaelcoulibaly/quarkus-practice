package org.ila;

import java.util.Map;

import javax.annotation.security.RolesAllowed;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.eclipse.microprofile.jwt.JsonWebToken;

@Path("/api/admin")
public class AdminResource {

    @Inject
    JsonWebToken jwt;

    @GET
    @RolesAllowed("admin")
    public Map<String, String> admin() {
        return Map.of(
                "subject", jwt.getSubject(),
                "preferred_username", jwt.getClaim("preferred_username")
        );
    }
}