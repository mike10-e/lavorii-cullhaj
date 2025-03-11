package it.html.tutorial.library.api;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("api")
public class LibraryApplication extends ResourceConfig {
    public LibraryApplication() {
        packages("it.html.tutorial.library.api");
    }
}