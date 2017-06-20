package hsbclearn.simpleapp.examples;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import hsbclearn.simpleapp.examples.ejb.AppService;

@WebServlet("/ExampleServletJPA")
public class ExampleServletJPA extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	AppService appService;
	
	public ExampleServletJPA() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		appService.createNewPersonWithPhones();
		response.getWriter()
			.append("JPA Servlet Served at: ")
			.append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}	
	
}
