package es.jsmontesinos.ajrtest.services;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import es.jsmontesinos.ajrtest.controllers.ContactController;
import es.jsmontesinos.ajrtest.entities.Contact;
import es.jsmontesinos.ajrtest.exceptions.ContactDupplicatedException;
import es.jsmontesinos.ajrtest.exceptions.ContactNotFoundException;

@Path("/api/contacts")
@Stateless
@Consumes("application/json")
@Produces("application/json; charset=UTF-8")
public class ContactService {

	@Inject
	private ContactController service;
	
	@DELETE
	@Path("/{id}")
	public Response deleteContact(final @PathParam("id") Long id){
		try {
			service.remove(id);
			return Response.ok().build();
	    } catch (ContactNotFoundException cnfe){
	    	return Response.status(Response.Status.NOT_FOUND)
	        		.entity("Entity not found for id: " + id).build();
	    }
	}
	
	@PUT
	@Path("/{id}")
	public Response updateContact(@Valid Contact contact){
		return Response.status(Response.Status.OK).entity(service.upadte(contact)).build();
	}
	
	@POST
	public Response saveContact(@Valid Contact contact){
		try {
			return Response.status(Response.Status.CREATED).entity(service.save(contact)).build();
		} catch (ContactDupplicatedException cde){
	    	return Response.status(Response.Status.CONFLICT)
	        		.entity("Dupplicated email: " + contact.getEmail()).build();
	    }
	}
	
	@GET
	public Response getContacts(final @QueryParam("offset") Integer offset,
			final @QueryParam("limit") Integer limit) {
		return Response.ok(service.getAll(offset, limit))
				.header("X-Total-Count", service.count()).build();
	}

	@GET
	@Path("/{id}")
	public Response getContact(final @PathParam("id") Long id) {
		if(service.getById(id) == null) {
	        return Response.status(Response.Status.NOT_FOUND)
	        		.entity("Entity not found for id: " + id).build();
	    }
		return Response.ok(service.getById(id)).build();
	}

}
