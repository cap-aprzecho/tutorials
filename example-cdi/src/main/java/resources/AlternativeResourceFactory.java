package resources;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;

import external.ExternalConnection;
import external.ExternalResourceDriver;

public class AlternativeResourceFactory {
	ExternalResourceDriver driver;
	
	@PostConstruct
	public void init() {
		driver = ExternalResourceDriver.getDriver();
	}
	
	@Produces
	public ExternalConnection createConnection() {
		ExternalConnection conn = driver.createConnection();
		conn.openConnection();
		return conn;
	}
	
	public void closeConnection(@Disposes ExternalConnection connection) {
		connection.closeConnection();
	}
	
}
