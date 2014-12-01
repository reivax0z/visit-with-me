package reivax.norac.website.service;

import java.util.List;

import reivax.norac.website.dto.ArticleDTO;
import reivax.norac.website.dto.CitiesVisitedDTO;
import reivax.norac.website.dto.CountriesVisitedDTO;
import reivax.norac.website.dto.UsersDTO;

public interface ServicesInterface {

	// Generic getter from ID
	public <T> T getFromDb(Class<T> t, Integer id);
	
	// Insert
	public void addCountryToDb(CountriesVisitedDTO countryDTO);
	public void updateCountryToDb(CountriesVisitedDTO countryDTO);
	public void addArticleToDb(ArticleDTO articleDTO);
	public void updateArticleToDb(ArticleDTO articleDTO);
	public void addCityToDb(CitiesVisitedDTO cityDTO);
	public void updateCityToDb(CitiesVisitedDTO cityDTO);
	
	// Specific getters
	public List<CountriesVisitedDTO> getAllCountriesFromDb();
	public List<CitiesVisitedDTO> getAllCitiesFromDb();
	public List<ArticleDTO> getAllArticlesFromDb();
	public List<UsersDTO> getAllUsersFromDb();
}
