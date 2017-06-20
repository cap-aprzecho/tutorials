package hsbclearn.simpleapp.examples.ejb;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
public class ExampleEJB {

	// domyslny sposob propagacji transakcji, nie ma potrzeby podawania go jawnie
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void executeTransacted() {
		System.out.println("executing Example EJB");
	}
}
