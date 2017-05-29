package example.cdi.app;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

import example.cdi.service.Counted;
import example.cdi.service.IOperationBean;
import session.SessionStatementCounter;

@SessionScoped
public class GUIContoller implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Inject
	IOperationBean techSrv1;
	
	@Inject
	@Counted
	IOperationBean busSrv1;
	
	@Inject
	SessionStatementCounter counter;

	public void execute() {
		techSrv1.executeOperation("TECH stmt 1");	
		techSrv1.executeOperation("TECH stmt 2");		

		busSrv1.executeOperation("BUS STMT 1");				
		busSrv1.executeOperation("BUS STMT 2");
		
		System.out.println("Executed statements: " + counter.getCounter());
	}
}
