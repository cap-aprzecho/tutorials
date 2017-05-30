package example.cdi.service;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import resources.Ready;
import session.SessionStatementCounter;

@Counted
@Dependent
public class BussinesOperationBean implements IOperationBean {

	@Inject
	Queue queue;

	@Inject
	@Ready
	Session session;

	@Inject
	SessionStatementCounter stmtCounter;

	@Override
	public void executeOperation(String stmt) {
		try {
			TextMessage msg = session.createTextMessage();
			msg.setText(stmt);

			MessageProducer producer = session.createProducer(queue);
			producer.send(msg);

			stmtCounter.increment();

		} catch (JMSException e) {
			e.printStackTrace();
		}

	}

}
