package session;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;

@SessionScoped
public class SessionStatementCounter implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int stmtCounter;
	
	@PostConstruct
	public void init() {
		stmtCounter = 0;
	}
	
	public void increment() {
		stmtCounter++;
	}
	
	public int getCounter() {
		return stmtCounter;
	}
	
}
