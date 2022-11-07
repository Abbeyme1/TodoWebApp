package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import classes.Todo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "HandleTask", urlPatterns = "/handleTask", initParams = {
		
})
public class HandleTask extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		int index = Integer.parseInt(req.getParameter("index"));
		
		HttpSession session = req.getSession();
		
		@SuppressWarnings("unchecked")
		List<Todo> todos = (List<Todo>) session.getAttribute("todo");
		todos.get(index).changeDone();
		
		System.out.println(todos.get(index).isDone());
		res.sendRedirect("index.jsp");
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int index = Integer.parseInt(req.getParameter("index"));
		
		HttpSession session = req.getSession();
		
		@SuppressWarnings("unchecked")
		List<Todo> todos = (List<Todo>) session.getAttribute("todo");
		todos.remove(index);
		
		res.sendRedirect("index.jsp");
	}
}
