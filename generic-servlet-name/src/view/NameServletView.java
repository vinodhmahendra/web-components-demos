package view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet implementation class NameServletView
 */
public class NameServletView extends GenericServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#service(ServletRequest request, ServletResponse response)
	 */
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// read the request parameter
		String fname = request.getParameter("FIRST_NAME");
		String lname = request.getParameter("LAST_NAME");
		
		// set the MIME type
		response.setContentType("text/html");
		
		// obtain a PrintWriter object
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>welcome to  generic servlet </title>");
		out.println("</head>");

		out.println("<body>");
		out.println("<h2>welcome "+fname + "  " +lname+" to simplilearn!</h2>");

		out.println("</body>");

		out.print("</html>");
		
		out.close();
	}

}
