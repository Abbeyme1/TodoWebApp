import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Temp extends HttpServlet {

	protected void service(HttpServletRequest req, HttpServletResponse arg1) throws ServletException, IOException {
		
		
		HttpSession s = req.getSession();
		String name = (String) s.getAttribute("username");
	}

}
