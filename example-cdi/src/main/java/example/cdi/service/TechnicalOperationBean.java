package example.cdi.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import external.ExternalConnection;
import resources.ResourceFactory;

@ApplicationScoped
public class TechnicalOperationBean implements IOperationBean {

	@Inject
	ResourceFactory resourceFactory;

	@Override
	public void executeOperation(String stmt) {
		ExternalConnection connection = resourceFactory.getConnection();
		connection.executeStatement(stmt);
		connection.closeConnection();
	}
}
