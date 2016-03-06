package es.jsmontesinos.ajrtest.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import es.jsmontesinos.ajrtest.dao.ContactDao;
import es.jsmontesinos.ajrtest.entities.Contact;

@Stateless
@Default
public class JpaContactDao implements ContactDao{
	
	@Inject
	private EntityManager em;
	
	@Override
	public Contact find(Long id){
    	return em.find(Contact.class, id);
    }
    
    @SuppressWarnings("unchecked")
    @Override
	public List<Contact> findAll(int first, int max) {
        final Query query = em.createQuery("SELECT c FROM Contact c ORDER BY c.id");
        query.setFirstResult(first);
        query.setMaxResults(max);
        return (List<Contact>) query.getResultList();
    }
    
    @Override
    public Contact save(Contact contact) {
		em.persist(contact);
		return contact;
	}

    @Override
	public Long count() {
		String sql = "SELECT COUNT(c) FROM Contact c";
		Query q = em.createQuery(sql);
		return (Long)q.getSingleResult();
	}

    @Override
	public void remove(Long id) {
		em.remove(find(id));
	}

    @Override
	public Contact upadte(Contact contact) {
		em.merge(contact);
		return contact;
	}

}
