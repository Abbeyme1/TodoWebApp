package servlets;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import classes.Todo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet(name = "Add", urlPatterns = "/add", initParams = {
		@WebInitParam(name="Descripion", value = "Not Provided"),
		@WebInitParam(name="done", value = "Not Provided")
})
public class AddTask extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("inside post");
		String description = req.getParameter("description").strip();
		
		if(description.length() == 0)
		{
			req.setAttribute("error", "Add Description");
			req.getRequestDispatcher("index.jsp").forward(req, res);
//			res.sendRedirect("index.jsp");
		}
		else
		{
			req.removeAttribute("error");
			
			Todo todo = new Todo(description);
			
			HttpSession session = req.getSession();
			
			if(session.getAttribute("todo") == null) session.setAttribute("todo", new ArrayList<Todo>());
			
			@SuppressWarnings("unchecked")
			List<Todo> todos = (List<Todo>) session.getAttribute("todo");
			todos.add(todo);
			
			res.sendRedirect("index.jsp");
			
			
			
		}
		
		

	}
	
	
	
	
}
