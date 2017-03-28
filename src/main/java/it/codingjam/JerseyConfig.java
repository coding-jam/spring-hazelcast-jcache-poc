package it.codingjam;

import it.codingjam.resources.CachedResource;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        packages(CachedResource.class.getPackage().getName());
    }
}
