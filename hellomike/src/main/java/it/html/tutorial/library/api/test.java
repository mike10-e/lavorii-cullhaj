package it.html.tutorial.library.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("test")
public class test {
	@GET
	@Path("{name}")
	public String test(@PathParam("name") String name) {
		return "Ciao " + name.toUpperCase();
	}
}