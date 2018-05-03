package cali.eventkalender.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("")
public class IndexServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public IndexServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/pages/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	/*	String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		Person p = new Person(firstName, lastName);
		facade.addPerson(p);
		
		System.out.println(firstName + " " + lastName);
		
		doGet(request,response);  */
	}
	
}
