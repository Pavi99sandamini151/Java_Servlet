package com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import dto.User;

/**
 * Servlet implementation class SummeryServlet
 */
public class SummeryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SummeryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
HttpSession session =request.getSession(false);
		
		if(session != null) {
			User u = (User) session.getAttribute("user");
			u.setCity(request.getParameter("city"));
			u.setContact(Long.parseLong(request.getParameter("contact")));
			
			PrintWriter out = response.getWriter();
			out.println("<h2> Hello" + u.getEmail() + "</h2>");
			out.println("<h3> Details .." + u + "</h3>");
			out.println("<h4> Session Id: "+ session.getId()+ "</h4>");
			out.println("<h4> Session created at: "+ session.getCreationTime() + " </h4>");
			
		}
	}

}
