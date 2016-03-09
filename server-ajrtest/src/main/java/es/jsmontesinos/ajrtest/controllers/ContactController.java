package es.jsmontesinos.ajrtest.controllers;


import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import es.jsmontesinos.ajrtest.dao.ContactDao;
import es.jsmontesinos.ajrtest.entities.Contact;
import es.jsmontesinos.ajrtest.exceptions.ContactNotFoundException;

@Stateless
public class ContactController {
	
	@Inject
	private ContactDao cdao;

    public Contact getById(Long id){
    	return cdao.find(id);
    }
    
    public List<Contact> getAll(int first, int max) {
        return cdao.findAll(first, max);
    }
    
    public Contact save(Contact contact) {
		return cdao.save(contact);
	}

	public Long count() {
		return cdao.count();
	}

	public void remove(Long id) {
		if(cdao.find(id) == null) {
	        throw new ContactNotFoundException();
	    }
		cdao.remove(id);
	}

	public Contact upadte(Contact contact) {
		return cdao.upadte(contact);
	}


}
