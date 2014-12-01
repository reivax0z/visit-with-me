package reivax.norac.website.caches;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.NamingException;

import reivax.norac.website.dto.ArticleDTO;
import reivax.norac.website.service.WebSiteEJB;

public class ArticleCache extends Cache<ArticleDTO> {
	
	public ArticleCache(String name) {
		super(name);
	}

	private static ArticleCache instance = new ArticleCache("Blog cache");
	
	public static ArticleCache getInstance(){
		return instance;
	}
	
	@Override
	protected List<ArticleDTO> refreshAllAction() {
		return webSiteEJB.getAllArticlesFromDb();
	}

	@Override
	protected void addAction(ArticleDTO element) {
		webSiteEJB.addArticleToDb(element);
	}

	@Override
	protected void updateAction(ArticleDTO element) {
		webSiteEJB.updateArticleToDb(element);
	}

}
