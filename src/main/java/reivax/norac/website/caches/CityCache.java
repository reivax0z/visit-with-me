package reivax.norac.website.caches;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.NamingException;

import reivax.norac.website.dto.CitiesVisitedDTO;
import reivax.norac.website.service.WebSiteEJB;

public class CityCache extends Cache<CitiesVisitedDTO> {
	
	public CityCache(String name) {
		super(name);
	}

	private static CityCache instance = new CityCache("City cache");
	
	public static CityCache getInstance(){
		return instance;
	}

	@Override
	protected List<CitiesVisitedDTO> refreshAllAction() {
		return webSiteEJB.getAllCitiesFromDb();
	}

	@Override
	protected void addAction(CitiesVisitedDTO element) {
		webSiteEJB.addCityToDb(element);
	}

	@Override
	protected void updateAction(CitiesVisitedDTO element) {
		webSiteEJB.updateCityToDb(element);
	}

}
