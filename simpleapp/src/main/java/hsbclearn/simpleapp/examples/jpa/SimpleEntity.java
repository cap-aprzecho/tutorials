package hsbclearn.simpleapp.examples.jpa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class SimpleEntity {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="OUR_TEXT")
	private String text;
	
	@Transient
	private String debugInfo;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date timestamp;
	
	@Lob
	private byte[] myFile;
	
	@Lob
	private String myXml;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
