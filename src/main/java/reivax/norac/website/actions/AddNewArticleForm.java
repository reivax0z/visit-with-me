package reivax.norac.website.actions;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reivax.norac.website.caches.ArticleCache;
import reivax.norac.website.dto.ArticleDTO;
import reivax.norac.website.dto.CountriesVisitedDTO;
import reivax.norac.website.model.Article;
import reivax.norac.website.service.WebSiteEJB;
import reivax.norac.website.util.CommonsUtils;

/**
 * Servlet implementation class AddNewArticleForm
 */
//@WebServlet(name="/AddNewArticleForm", urlPatterns={"/AddNewArticleFormAction"})
public class AddNewArticleForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddNewArticleForm() {
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
		
		String id = request.getParameter("id");
		if(id != null && request.getSession().getAttribute("newArticle") == null){
			// We edit an existing article
			Integer i = Integer.parseInt(id);
			ArticleDTO a = CommonsUtils.getArticleById(i, ArticleCache.getInstance().getAll());
			request.getSession().setAttribute("newArticle", a);
		}
		
		// Forward the info to the appropriate JSP
		request.getRequestDispatcher("jsp/AddNewBlogArticle.jsp").forward(request, response);
	}

}
