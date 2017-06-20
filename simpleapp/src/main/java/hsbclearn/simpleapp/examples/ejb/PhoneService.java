package hsbclearn.simpleapp.examples.ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import hsbclearn.simpleapp.examples.jpa.Person;
import hsbclearn.simpleapp.examples.jpa.Phone;

@Stateless
public class PhoneService {
	
	@PersistenceContext
	private EntityManager em;
	
	public Phone createPhone(Person person, int number) {
		Phone phone = new Phone();
		phone.setNumber(number);
		
		phone.setMyPerson(person);
		person.getPhones().add(phone);
		
		em.persist(phone);
		
		return phone;
	}
	
}
