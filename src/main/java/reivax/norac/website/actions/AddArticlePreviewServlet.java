package reivax.norac.website.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
import reivax.norac.website.dto.ArticlePartDTO;
import reivax.norac.website.service.WebSiteEJB;
import reivax.norac.website.util.CommonsUtils;
import reivax.norac.website.utilities.Utils;

/**
 * Servlet implementation class AddArticlePreviewServlet
 */
@WebServlet(name="/AddArticlePreviewServlet", urlPatterns={"/AddArticlePreviewAction"})
public class AddArticlePreviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddArticlePreviewServlet() {
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
		String title = request.getParameter("title");
		String intro = request.getParameter("intro");
		String conclusion = request.getParameter("conclusion");
		String date = Utils.getStringDateFromDate(new Date());
		
		ArrayList<ArticlePartDTO> parts = new ArrayList<ArticlePartDTO>();
		for(int i=0; i<10; i++){
			String titlePart = request.getParameter("title_part_"+i);
			String contentPart = request.getParameter("content_part_"+i);
			String id = request.getParameter("part_id_"+i);
			if(titlePart != null && !titlePart.isEmpty()){
				ArticlePartDTO dto = new ArticlePartDTO();
				dto.setTitle(titlePart);
				dto.setBody(contentPart);
				dto.setId(Integer.parseInt(id));
				parts.add(dto);
			}
		}
		
		if(title != null && intro != null && conclusion != null){
		
			ArticleDTO dto = new ArticleDTO();
			dto.setTitle(title);
			dto.setDate(date);
			dto.setIntro(intro);
			dto.setConclusion(conclusion);
			dto.setArticleParts(parts);
			
			if(request.getSession().getAttribute("newArticle") != null){
				ArticleDTO preDto = (ArticleDTO) request.getSession().getAttribute("newArticle");
				dto.setId(preDto.getId());
				dto.setDate(preDto.getDate());
			}
			
			request.getSession().setAttribute("newArticle", dto);
			request.getSession().setAttribute("isEditMode", Boolean.TRUE);
		}
		
		// Get back all the articles from DB
		List<ArticleDTO> blogArticles = ArticleCache.getInstance().getAll();
		
		Map<String, Map<String, List<ArticleDTO>>> map = CommonsUtils.getArticlesMapByYearByMonth(blogArticles);
		request.setAttribute("blogArticlesMapByDate", map);
		
		request.getRequestDispatcher("jsp/BlogDisplayOneArticle.jsp").forward(request, response);
	}

}
