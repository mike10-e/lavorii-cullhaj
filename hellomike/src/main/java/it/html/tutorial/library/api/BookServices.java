package it.html.tutorial.library.api;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;

@Produces(MediaType.APPLICATION_JSON)
@Path("books")
public class BookServices {
	@GET
	public List list() {
		List books = new ArrayList();
		Author author = new Author();
		author.setId(1);
		author.setName("Joanne");
		author.setSurname("Rowling");
		Book book1 = new Book();
		book1.setId(1);
		book1.setTitle("Harry Potter and the Philosopher's Stone");
		book1.setLanguage("english");
		List authors = new ArrayList();
		authors.add(author);
		book1.setAuthors(authors);
		books.add(book1);
		Book book2 = new Book();
		book2.setId(2);
		book2.setTitle("Harry Potter and the Chamber of Secrets");
		book2.setLanguage("english");
		book2.setAuthors(authors);
		books.add(book2);
		return books;
	}
	@GET
	@Path("{id}")
	public Book get(@PathParam("{id}") long id) {
		Author author = new Author();
		author.setId(1);
		author.setName("Joanne");
		author.setSurname("Rowling");
		Book book = new Book();
		book.setId(1);
		book.setTitle("Harry Potter and the Philosopher's Stone");
		book.setLanguage("english");
		List authors = new ArrayList();
		authors.add(author);
		book.setAuthors(authors);
		return book;
	}
	@POST
	public Response add(Book book) throws URISyntaxException {
		long newId = 3;
		return Response.created(new URI("api/books/" + newId)).build();
	}
	@PUT
	@Path("{id}")
	public Response update(@PathParam("{id}") long id, Book book) {
		return Response.noContent().build();
	}
	@DELETE
	@Path("{id}")
	public Response delete(@PathParam("{id}") long id) {
		return Response.noContent().build();
	}
}