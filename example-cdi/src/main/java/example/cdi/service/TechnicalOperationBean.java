package example.cdi.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

@ApplicationScoped
public class TechnicalOperationBean implements IOperationBean {

	@Inject
	ConnectionFactory connectionFactory;
	
	@Inject
	Queue queue;

	@Override
	public void executeOperation(String stmt) {
		try {
			Connection connection = connectionFactory.createConnection();			
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			
			TextMessage msg = session.createTextMessage();
			msg.setText(stmt);
			
			MessageProducer producer = session.createProducer(queue);
			producer.send(msg);
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
