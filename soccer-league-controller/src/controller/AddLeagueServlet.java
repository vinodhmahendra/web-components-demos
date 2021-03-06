package controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.League;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
// Support classes
import java.io.IOException;
// Model classes

import java.util.List;
import java.util.LinkedList;

public class AddLeagueServlet extends HttpServlet {
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException, ServletException {
        
        // Keep a set of strings to record form processing errors.
        List errorMsgs = new LinkedList();
        // Store this set in the request scope, in case we need to
        // send the ErrorPage view.
        request.setAttribute("errorMsgs", errorMsgs);
        
        try {
            
            // Retrieve form parameters.
            String yearStr = request.getParameter("year").trim();
            String season = request.getParameter("season").trim();
            String title = request.getParameter("title").trim();
            
            // Perform data conversions.
            int year = -1;
            try {
                year = Integer.parseInt(yearStr);
            } catch (NumberFormatException nfe) {
                errorMsgs.add("The 'year' field must be a positive integer.");
            }
            
            // Verify form parameters
            if ( (year != -1) && ((year < 2000) || (year > 2010)) ) {
                errorMsgs.add("The 'year' field must within 2000 to 2010.");
            }
            if ( season.equals("UNKNOWN") ) {
                errorMsgs.add("Please select a league season.");
            }
            if ( title.length() == 0 ) {
                errorMsgs.add("Please enter the title of the league.");
            }
            
            // Send the ErrorPage view if there were errors
            if ( ! errorMsgs.isEmpty() ) {
                RequestDispatcher view
                        = request.getRequestDispatcher("error_page.view");
                view.forward(request, response);
                return;
            }
            
            // Perform business logic
            League league = new League(year, season, title);
            // Store the new league in the request-scope
            request.setAttribute("league", league);
            
            // Send the Success view
            RequestDispatcher view
                    = request.getRequestDispatcher("success.view");
            view.forward(request, response);
            return;
            
            // Handle any unexpected exceptions
        } catch (RuntimeException e) {
            errorMsgs.add(e.getMessage());
            RequestDispatcher view
                    = request.getRequestDispatcher("error_page.view");
            view.forward(request, response);
            
            // Log stack trace
            e.printStackTrace(System.err);
            
        } // END of try-catch block
        
    } // END of doPost method
    
} // END of AddLeagueServlet class
