package reivax.norac.website.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reivax.norac.website.dto.CountriesVisitedDTO;
import reivax.norac.website.util.CommonsUtils;

/**
 * Servlet implementation class AboutMeServlet
 */
@WebServlet(name="/AboutMeServlet", urlPatterns={"/AboutMe", "/About"})
public class AboutMeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AboutMeServlet() {
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
		CommonsUtils.cleanSession(request);
		
		// Forward the info to the appropriate JSP
		request.getRequestDispatcher("jsp/About.jsp").forward(request, response);
	}
	
}
