package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import model.League;


public class LisLeagueServlet extends GenericServlet {
	private static final long serialVersionUID = 1L;

	private List<League> leagueList = null;
	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		 
        // Create the set of leagues
        leagueList = new LinkedList<League>();
        leagueList.add( new League(2021, "Spring",
                "Soccer League (Spring '21)") );
        leagueList.add( new League(2021, "Summer",
                "Summer Soccer Fest 2021") );
        leagueList.add( new League(2021, "Fall",
                "Fall Soccer League (2021)") );
        leagueList.add( new League(2021, "Spring",
                "Soccer League (Spring '21)") );
        leagueList.add( new League(2021, "Summer",
                "The Summer of Soccer Love 2021") );
        leagueList.add( new League(2021, "Fall",
                "Fall Soccer League (2021)") );
        
        // Set page title
        String pageTitle = "Duke's Soccer League: List Leagues";
        
        // Specify the content type is HTML
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // Generate the HTML response
        out.println("<html>");
        out.println("<head>");
        out.println("  <title>" + pageTitle + "</title>");
        out.println("</head>");
        out.println("<body bgcolor='white'>");
        
        // Generate page heading
        out.println("<!-- Page Heading -->");
        out.println("<table border='1' cellpadding='5' cellspacing='0' width='400'>");
        out.println("<tr bgcolor='#CCCCFF' align='center' valign='center' height='20'>");
        out.println("  <td><h3>" + pageTitle + "</h3></td>");
        out.println("</tr>");
        out.println("</table>");
        
        // Generate main body
        out.println("<p>The set of soccer leagues:</p>");
        out.println("<ul>");
        Iterator<League> items = leagueList.iterator();
        while ( items.hasNext() ) {
            League league = (League) items.next();
            out.println("  <li>" + league.getTitle() + "</li>");
        }
        out.println("</ul>");
        out.println("<p>End of list.</p>");
        
        out.println("</body>");
        out.println("</html>");
		
	}

}
