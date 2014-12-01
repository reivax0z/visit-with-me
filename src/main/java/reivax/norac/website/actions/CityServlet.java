package reivax.norac.website.actions;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reivax.norac.website.caches.CityCache;
import reivax.norac.website.caches.CountryCache;
import reivax.norac.website.dto.CitiesVisitedDTO;
import reivax.norac.website.dto.CountriesVisitedDTO;
import reivax.norac.website.service.WebSiteEJB;
import reivax.norac.website.utilities.FlickrHelper;

/**
 * Servlet implementation class CityServlet
 */
@WebServlet(name="/CityDetails", urlPatterns={"/CityDetailsAction"})
public class CityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityServlet() {
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
		String cityName = request.getParameter("city");
		
		// Get back the city details from the DB
		List<CitiesVisitedDTO> cities = CityCache.getInstance().getAll();
		
		// Get back all the countries from DB
		List<CountriesVisitedDTO> countries = CountryCache.getInstance().getAll();

		// Forward the info to the appropriate JSP
		request.setAttribute("countries", countries);
		

		for(CitiesVisitedDTO c : cities){
			if(c.getName().equals(cityName)){

				// Forward the info to the appropriate JSP
				request.setAttribute("city", c);
				request.getRequestDispatcher("jsp/DisplayOneCityReal.jsp").forward(request, response);
			}
		}
		
		// Else, error...
		response.getWriter().println("Nothing in DB...");
		
	}
}
