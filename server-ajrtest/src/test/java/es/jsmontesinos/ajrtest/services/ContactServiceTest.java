package es.jsmontesinos.ajrtest.services;

import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import es.jsmontesinos.ajrtest.controllers.ContactController;
import es.jsmontesinos.ajrtest.dao.ContactDao;
import es.jsmontesinos.ajrtest.entities.Contact;
import es.jsmontesinos.ajrtest.exceptions.ContactNotFoundException;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest {
	
	@Mock
	private ContactDao cdao;
	
	@InjectMocks
    private ContactController service;

	@Test(expected = ContactNotFoundException.class)  
	public void should_throw_exception_if_remove_not_existing_contact() {
		when(cdao.find(anyLong())).thenReturn(null);
		
		service.remove(Long.valueOf(1));
	}
	
	@Test
	public void should_call_remove_if_id_exists() {
		Contact contact = new Contact();
		contact.setId(Long.valueOf(1));
		when(cdao.find(anyLong())).thenReturn(contact);
		
		service.remove(Long.valueOf(1));
		
		verify(cdao).remove(contact.getId());
	}
	

}
