package reivax.norac.website.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reivax.norac.website.caches.ArticleCache;
import reivax.norac.website.dto.ArticleDTO;
import reivax.norac.website.service.WebSiteEJB;
import reivax.norac.website.util.CommonsUtils;
import reivax.norac.website.utilities.Utils;

/**
 * Servlet implementation class BlogServlet
 */
@WebServlet(name="/BlogList", urlPatterns={"/Blog"})
public class BlogServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BlogServlet() {
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
		// Get properties
		Integer nbMaxArticleDisplay = Integer.valueOf(CommonsUtils.getProperties(getServletContext()).getProperty("blog_article_nb"));
		
		// Get back all the articles from DB
		List<ArticleDTO> blogArticles = ArticleCache.getInstance().getAll();

		CommonsUtils.cleanSession(request);
		
		// Forward the info to the appropriate JSP
		request.setAttribute("nbMaxArticleDisplay", nbMaxArticleDisplay);
		request.setAttribute("blogArticles", blogArticles);
		request.setAttribute("blogArticlesMapByDate", CommonsUtils.getArticlesMapByYearByMonth(blogArticles));
		request.getRequestDispatcher("jsp/Blog.jsp").forward(request, response);
	}

}
