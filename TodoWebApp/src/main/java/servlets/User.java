package servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "UserHandler", urlPatterns = "/user")
public class User extends HttpServlet {
	
	// logout
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		req.getSession().invalidate();
		res.sendRedirect("index.jsp");
	}
	
	// SIGNUP
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("post");
		
		String username = getParameter(req,"name");
		String email = getParameter(req,"email");
		String password = getParameter(req,"password");
		
		// save to database
		
		
		HttpSession session = req.getSession();
		session.setAttribute("username", username);
		session.setAttribute("email", email);
		session.setAttribute("password", password);
		
		res.sendRedirect("index.jsp");
		
		
	}
	
	
	
	// SIGNOUT
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("delete");
	}
	
	public String getParameter(HttpServletRequest req, String attr)
	{
		String param = req.getParameter(attr);
		
		// handle null/empty
		
		return param;
	}

}
