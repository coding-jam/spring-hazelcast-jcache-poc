package it.codingjam.resources;

import it.codingjam.services.CachedService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/cached")
public class CachedResource {

    @Inject
    private CachedService cachedService;

    @GET
    public String ping() throws InterruptedException {
        return cachedService.timeConsumingOperation();
    }
}
