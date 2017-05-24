package hsbclearn.simpleapp.xml;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import hsbclearn.simpleapp.IntegerWrapper;

public class JAXBParser implements IMessageParser {

	@Override
	public String saveAsXML(List<IntegerWrapper> data) {
		 String result = "";
		 
		 XMLMessage msg = new XMLMessage();
		 msg.setDataList(data);
		 
		try {
			StringWriter sw = new StringWriter();
		    JAXBContext context = JAXBContext.newInstance(XMLMessage.class);
		    Marshaller marshaller = context.createMarshaller();
		    marshaller.marshal(msg, sw);
		    result = sw.toString();
		} catch (JAXBException e) {
		    e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public List<IntegerWrapper> readXML(String xmlString) {
		JAXBContext jaxbContext;
		StringReader reader = new StringReader(xmlString);
		List<IntegerWrapper> result = new ArrayList<IntegerWrapper>();
		try {
			jaxbContext = JAXBContext.newInstance(XMLMessage.class);
			Unmarshaller jaxbMarshaller = jaxbContext.createUnmarshaller();		
			jaxbMarshaller.unmarshal(reader);
		} catch (JAXBException e) {
			e.printStackTrace();
		}		
		return result;
	}

}
