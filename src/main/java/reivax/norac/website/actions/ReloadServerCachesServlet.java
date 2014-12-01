package reivax.norac.website.actions;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reivax.norac.website.caches.ArticleCache;
import reivax.norac.website.caches.CityCache;
import reivax.norac.website.caches.CountryCache;
import reivax.norac.website.caches.FlickrPhotoCache;
import reivax.norac.website.caches.UserCache;
import reivax.norac.website.dto.CountriesVisitedDTO;
import reivax.norac.website.util.CommonsUtils;

/**
 * Servlet implementation class ReloadServerCachesServlet
 */
@WebServlet(name="/ReloadServerCachesServlet", urlPatterns={"/ReloadServerCachesAction"})
public class ReloadServerCachesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReloadServerCachesServlet() {
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
		UserCache.getInstance().refreshAll();
		ArticleCache.getInstance().refreshAll();
		FlickrPhotoCache.getInstance().refreshAll();
		CityCache.getInstance().refreshAll();
		CountryCache.getInstance().refreshAll();
		
		CommonsUtils.cleanSession(request);
		
		// Forward the info to the appropriate JSP
		request.getRequestDispatcher("jsp/Admin.jsp").forward(request, response);
	}

}
