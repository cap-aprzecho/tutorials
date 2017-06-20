package hsbclearn.simpleapp.examples.ejb;


import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig={
		@ActivationConfigProperty(propertyName="destinationType",
								  propertyValue="javax.jms.Queue"),
		@ActivationConfigProperty(propertyName="destination",
								  propertyValue="jms/simpleAppRequestQueue")
})
public class AsyncClientMDB implements MessageListener {

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public void onMessage(Message message) {
		TextMessage msg = (TextMessage) message;
		try {
			System.out.println("MESSAGE RECEIVED: " + msg.getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}		
	}

}
