package example.cdi.service;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import external.ExternalConnection;
import session.SessionStatementCounter;

@Counted
@Dependent
public class BussinesOperationBean implements IOperationBean {

	@Inject
	ExternalConnection connection;
	
	@Inject
	SessionStatementCounter stmtCounter;
	
	@Override
	public void executeOperation(String stmt) {
		connection.executeStatement(stmt);
		stmtCounter.increment();
	}

}
