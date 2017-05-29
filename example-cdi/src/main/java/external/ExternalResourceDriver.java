package external;

public class ExternalResourceDriver {

	public static ExternalResourceDriver getDriver() {
		return new ExternalResourceDriver();
	}
	
	public ExternalConnection createConnection() {
		return new ExternalConnection();
	}
	
}
