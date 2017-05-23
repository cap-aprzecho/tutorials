package hsbclearn.simpleapp.output;

import java.util.List;

import hsbclearn.simpleapp.IDataOutput;
import hsbclearn.simpleapp.IntegerWrapper;
import hsbclearn.simpleapp.xml.IMessageParser;
import hsbclearn.simpleapp.xml.JAXBParser;

public class FakeXmlConsoleDataOutput implements IDataOutput {

	@Override
	public void writeData(List<IntegerWrapper> data) {		
		IMessageParser parser = new JAXBParser();
		String xmlResult = parser.saveAsXML(data);
		System.out.println(xmlResult);
	}

}
