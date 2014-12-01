package reivax.norac.website.caches;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.naming.NamingException;

import reivax.norac.website.dto.CountriesVisitedDTO;
import reivax.norac.website.service.WebSiteEJB;

public class CountryCache extends Cache<CountriesVisitedDTO> {
	
	public CountryCache(String name) {
		super(name);
	}

	private static CountryCache instance = new CountryCache("Country cache");
	
	public static CountryCache getInstance(){
		return instance;
	}

	@Override
	protected List<CountriesVisitedDTO> refreshAllAction() {
		return webSiteEJB.getAllCountriesFromDb();
	}

	@Override
	protected void addAction(CountriesVisitedDTO element) {
		webSiteEJB.addCountryToDb(element);
	}

	@Override
	protected void updateAction(CountriesVisitedDTO element) {
		webSiteEJB.updateCountryToDb(element);
	}
}
