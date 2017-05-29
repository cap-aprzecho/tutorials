package resources;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;

import external.ExternalConnection;
import external.ExternalResourceDriver;

@ApplicationScoped
public class ResourceFactory {

	ExternalResourceDriver driver;
	
	@PostConstruct
	public void init() {
		driver = ExternalResourceDriver.getDriver();
	}
	
	public ExternalConnection getConnection() {
		return driver.createConnection();
	}
}
