package com.example.helloweb;

import org.glassfish.jersey.server.ResourceConfig;
import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("api")
public class LibraryApplication extends ResourceConfig {
    public LibraryApplication() {
        packages("com.example.helloweb");
    }
}
