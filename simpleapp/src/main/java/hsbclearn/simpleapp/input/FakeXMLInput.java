package hsbclearn.simpleapp.input;

import java.util.ArrayList;
import java.util.List;

import hsbclearn.simpleapp.IDataInput;
import hsbclearn.simpleapp.IntegerWrapper;
import hsbclearn.simpleapp.xml.IMessageParser;
import hsbclearn.simpleapp.xml.JAXBParser;

public class FakeXMLInput implements IDataInput {

	private static String xmlData = "<message>"
										+ "<data>"
											+ "<IntegerWrapper>"
												+ "<number>1</number>"
											+ "</IntegerWrapper>"
											+ "<IntegerWrapper>"
												+ "<number>2</number>"
											+ "</IntegerWrapper>"			
										+ "</data>"
									+ "</message>";
	
	@Override
	public List<IntegerWrapper> getData() {
		 List <IntegerWrapper> result = new ArrayList<IntegerWrapper>();
		 
		 IMessageParser parser = new JAXBParser();
		 List<IntegerWrapper> parsed = parser.readXML(xmlData);
		 result.addAll(parsed);
		 
		 return result;
	}
}
