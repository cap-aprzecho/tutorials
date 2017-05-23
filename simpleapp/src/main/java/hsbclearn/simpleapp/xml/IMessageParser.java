package hsbclearn.simpleapp.xml;

import java.util.List;

import hsbclearn.simpleapp.IntegerWrapper;

public interface IMessageParser {
	String saveAsXML(List<IntegerWrapper> data);
	List<IntegerWrapper> readXML(String xmlString);
}
