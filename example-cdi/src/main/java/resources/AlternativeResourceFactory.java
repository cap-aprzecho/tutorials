package resources;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Queue;
import javax.jms.Session;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

@ApplicationScoped
public class AlternativeResourceFactory {
	
	@Produces @Ready
	public ConnectionFactory getConnectionFactory() {
		try {
			Context ctx = new InitialContext();
			return (ConnectionFactory) ctx.lookup("jms/simpleAppConnectionFactory");			
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}

	}	
	
	@Produces @Ready
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
	
	@Produces @Ready
	public Connection createConnection(@Ready ConnectionFactory connectionFactory) {
		try {
			return connectionFactory.createConnection();
		} catch (JMSException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void closeConnection(@Disposes @Ready Connection connection) {
		try {
			connection.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	@Produces @Ready
	public Session createSession(@Ready Connection connection) {
		try {
			return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		} catch (JMSException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public void closeSession(@Disposes @Ready Session session) {
		try {
			session.close();
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}	
	
	
}
