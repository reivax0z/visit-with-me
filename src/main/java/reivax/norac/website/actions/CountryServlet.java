package reivax.norac.website.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reivax.norac.website.caches.CityCache;
import reivax.norac.website.caches.CountryCache;
import reivax.norac.website.dto.CitiesVisitedDTO;
import reivax.norac.website.dto.CountriesVisitedDTO;

/**
 * Servlet implementation class CountryServlet
 */
//@WebServlet(name="/CountryDetails", urlPatterns={"/CountryDetailsAction"})
public class CountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CountryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processData(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processData(request, response);
	}

	
	private void processData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get back the city name from the request
		String countryName = request.getParameter("country");
		
		// Get back all the countries from DB
		List<CountriesVisitedDTO> countries = CountryCache.getInstance().getAll();

		// Forward the info to the appropriate JSP
		request.setAttribute("countries", countries);
		

		for(CountriesVisitedDTO c : countries){
			if(c.getName().equals(countryName)){

				// Forward the info to the appropriate JSP
				request.setAttribute("country", c);
				request.getRequestDispatcher("jsp/DisplayOneCountry.jsp").forward(request, response);
			}
		}
		
		// Else, error...
		response.getWriter().println("Nothing in DB...");
		
	}
}
