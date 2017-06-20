package hsbclearn.simpleapp.examples.ejb;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import hsbclearn.simpleapp.examples.jpa.Person;
import hsbclearn.simpleapp.examples.jpa.Phone;

@Stateless
public class AppService {

	@PersistenceContext
	private EntityManager em;	
	
	@EJB
	private PersonService presonService;
	
	@EJB
	private PhoneService phoneService;
	
	public void createNewPersonWithPhones() {
		Person person = presonService.createNewPerson("ROMEK");
		phoneService.createPhone(person, 607000001);
		phoneService.createPhone(person, 607000002);
		
		// bez refresh id jest null - wszak id jest nadawany przez BD, nie przez nas
		// wiec trzeba encje odswiezyc by zobaczyc id nadany przez BD
		em.refresh(person);
		Integer personId = person.getId();
		
		List<Phone> phones = presonService.getPhonesForPerson(personId);
		for(Phone phone: phones) {
			System.out.println(person.getName() + " " + phone.getNumber());
		}
	}
}
