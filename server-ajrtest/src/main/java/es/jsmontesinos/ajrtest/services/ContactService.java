package es.jsmontesinos.ajrtest.services;


import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.jsmontesinos.ajrtest.entities.Contact;

public class ContactService {
	
	@Inject
    private EntityManager em;

    public Contact find(Long id){
    	return em.find(Contact.class, id);
    }
    
    @SuppressWarnings("unchecked")
	public List<Contact> findAll(int first, int max) {
        final Query query = em.createQuery("SELECT c FROM Contact c ORDER BY c.id");
        query.setFirstResult(first);
        query.setMaxResults(max);
        return (List<Contact>) query.getResultList();
    }
    
    public Contact save(Contact contact) {
		em.persist(contact);
		return contact;
	}

	public Long count() {
		String sql = "SELECT COUNT(c) FROM Contact c";
		Query q = em.createQuery(sql);
		return (Long)q.getSingleResult();
	}

	public void remove(Long id) {
		em.remove(find(id));
	}


}
