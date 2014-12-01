package reivax.norac.website.actions;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reivax.norac.website.caches.ArticleCache;
import reivax.norac.website.dto.ArticleDTO;
import reivax.norac.website.dto.ArticlePartDTO;
import reivax.norac.website.dto.CountriesVisitedDTO;
import reivax.norac.website.service.WebSiteEJB;
import reivax.norac.website.util.CommonsUtils;
import reivax.norac.website.utilities.Utils;

/**
 * Servlet implementation class AddArticleServlet
 */
//@WebServlet(name="/AddArticleServlet", urlPatterns={"/AddArticleAction"})
public class AddArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	@EJB 
	WebSiteEJB articleEJB;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get back dto and save in DB
		ArticleDTO dto = (ArticleDTO) request.getSession().getAttribute("newArticle");
		
		if(dto.getId() != 0){
			ArticleCache.getInstance().update(dto);
		} else{
			ArticleCache.getInstance().add(dto);
		}
		
		// Clean session attributes
		CommonsUtils.cleanSession(request);
		
		request.getRequestDispatcher("Blog").forward(request, response);
	}

}
