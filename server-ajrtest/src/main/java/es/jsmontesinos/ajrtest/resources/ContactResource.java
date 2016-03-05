package es.jsmontesinos.ajrtest.resources;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import es.jsmontesinos.ajrtest.entities.Contact;
import es.jsmontesinos.ajrtest.services.ContactService;

@Path("/api/contacts")
@Stateless
@Consumes("application/json")
@Produces("application/json; charset=UTF-8")
public class ContactResource {

	@Inject
	private ContactService service;
	
	@DELETE
	@Path("/{id}")
	public Response deleteContact(final @PathParam("id") Long id){
		if(service.find(id) == null) {
	        return Response.status(Response.Status.NOT_FOUND)
	        		.entity("Entity not found for id: " + id).build();
	    }
		service.remove(id);
		return Response.ok().build();
	}
	
	@POST
	public Response saveContact(@Valid Contact contact){
		return Response.status(Response.Status.CREATED).entity(service.save(contact)).build();
	}
	
	@GET
	public Response getContacts(final @QueryParam("offset") Integer offset,
			final @QueryParam("limit") Integer limit) {
		return Response.ok(service.findAll(offset, limit))
				.header("X-Total-Count", service.count()).build();
	}

	@GET
	@Path("/{id}")
	public Response getContact(final @PathParam("id") Long id) {
		if(service.find(id) == null) {
	        return Response.status(Response.Status.NOT_FOUND)
	        		.entity("Entity not found for id: " + id).build();
	    }
		return Response.ok(service.find(id)).build();
	}

}
