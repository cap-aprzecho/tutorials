package resources;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.jms.ConnectionFactory;
import javax.jms.Queue;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import external.ExternalConnection;
import external.ExternalResourceDriver;

@ApplicationScoped
public class ResourceFactory {

	ExternalResourceDriver driver;
	
	@PostConstruct
	public void init() {
		driver = ExternalResourceDriver.getDriver();
	}
	
	public ExternalConnection getConnection() {
		return driver.createConnection();
	}
	
	@Produces
	public Queue getQueue() {
		try {
			Context ctx = new InitialContext();
			String admDestName = "jms/SimpleAppDefaultQueue";
			Queue defaultQueue = (Queue) ctx.lookup(admDestName);
			return defaultQueue;
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Produces
	public ConnectionFactory getConnectionFactory() {
		try {
			Context ctx = new InitialContext();
			return (ConnectionFactory) ctx.lookup("jms/simpleAppConnectionFactory");			
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}

	}	
}
