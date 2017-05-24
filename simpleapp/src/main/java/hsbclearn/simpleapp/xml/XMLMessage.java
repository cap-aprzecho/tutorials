package hsbclearn.simpleapp.xml;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import hsbclearn.simpleapp.IntegerWrapper;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement
public class XMLMessage {
	
	public XMLMessage() {}
	
	@XmlElement(name="IntegerWrapper")
	@XmlElementWrapper(name="data")
	private List<IntegerWrapper> dataList;

	public List<IntegerWrapper> getDataList() {
		return dataList;
	}

	public void setDataList(List<IntegerWrapper> dataList) {
		this.dataList = dataList;
	}
	
	
}
