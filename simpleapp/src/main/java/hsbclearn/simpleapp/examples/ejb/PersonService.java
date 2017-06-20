package hsbclearn.simpleapp.examples.ejb;

import java.util.List;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import hsbclearn.simpleapp.examples.jpa.Person;
import hsbclearn.simpleapp.examples.jpa.Phone;

@Stateless

public class PersonService {

	@PersistenceContext
	private EntityManager em;

	public Person findPersonById(int id) {		
		return em.find(Person.class, id);
	}
	
	public Person createNewPerson(String name) {
		Person person = new Person();
		person.setName(name);
		
		em.persist(person);
		
		return person;
	}		
	
	public List<Phone> getPhonesForPerson(int personId) {
		TypedQuery<Phone> q = em.createNamedQuery("PHONES_BY_PERSON", Phone.class);
		q.setParameter("id", personId);
		return q.getResultList();
	}

}
