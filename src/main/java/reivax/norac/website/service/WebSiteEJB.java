package reivax.norac.website.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.hibernate.Session;

import reivax.norac.website.dto.ArticleDTO;
import reivax.norac.website.dto.CitiesVisitedDTO;
import reivax.norac.website.dto.CountriesVisitedDTO;
import reivax.norac.website.dto.UsersDTO;
import reivax.norac.website.model.Article;
import reivax.norac.website.model.City;
import reivax.norac.website.model.Country;
import reivax.norac.website.model.User;
import reivax.norac.website.utilities.Converter;
import reivax.norac.website.utilities.HibernateUtil;

/**
 * Session Bean implementation class WebSiteEJB
 */
@Stateless
@LocalBean
public class WebSiteEJB implements WebSiteEJBRemote, WebSiteEJBLocal, ServicesInterface {

	@EJB
	Converter converter;

	/**
	 * Default constructor. 
	 */
	public WebSiteEJB() {
	}

	@Override
	public List<CitiesVisitedDTO> getAllCitiesFromDb(){
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<City> cities = session.getNamedQuery("City.findAll").list();

		HibernateUtil.shutdown();

		return Converter.getCitiesDTOFromEntities(cities);
	}

	@Override
	public List<CountriesVisitedDTO> getAllCountriesFromDb(){

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Country> countries = session.getNamedQuery("Country.findAll").list();

		HibernateUtil.shutdown();

		return Converter.getCountriesDTOFromEntities(countries);
	}

	@Override
	public void addCountryToDb(CountriesVisitedDTO countryDTO){
		Country entity = Converter.getCountryFromDTO(countryDTO);

		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		session.save(entity);
		session.getTransaction().commit();

		HibernateUtil.shutdown();
	}

	@Override
	public void addArticleToDb(ArticleDTO articleDTO){

		Article entity = Converter.getArticleFromDTO(articleDTO);

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		session.save(entity);
		session.getTransaction().commit();

		HibernateUtil.shutdown();
	}

	@Override
	public <T> T getFromDb(Class<T> t, Integer id){

		Session session = HibernateUtil.getSessionFactory().openSession();
		return (T) session.get(t, id);
	}


	@Override
	public List<ArticleDTO> getAllArticlesFromDb() {

		Session session = HibernateUtil.getSessionFactory().openSession();
		List<Article> articles = session.getNamedQuery("Article.findAll").list();

		HibernateUtil.shutdown();
		return Converter.getArticlesDTOFromEntities(articles);
	}

	@Override
	public void updateArticleToDb(ArticleDTO articleDTO) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Article a = Converter.getArticleFromDTO(articleDTO);
		session.merge(a);
		
		session.getTransaction().commit();

		HibernateUtil.shutdown();
	}

	@Override
	public void addCityToDb(CitiesVisitedDTO cityDTO) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		City entity = converter.getCityFromDTO(cityDTO);
		session.save(entity);

		session.getTransaction().commit();

		HibernateUtil.shutdown();
	}

	@Override
	public void updateCityToDb(CitiesVisitedDTO cityDTO) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		City entity = converter.getCityFromDTO(cityDTO);
		session.merge(entity);

		session.getTransaction().commit();

		HibernateUtil.shutdown();
	}

	@Override
	public void updateCountryToDb(CountriesVisitedDTO countryDTO) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Country country = Converter.getCountryFromDTO(countryDTO);
		session.merge(country);

		session.getTransaction().commit();

		HibernateUtil.shutdown();
	}

	@Override
	public List<UsersDTO> getAllUsersFromDb() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		List<User> users = session.getNamedQuery("User.findAll").list();

		HibernateUtil.shutdown();
		return Converter.getUsersDTOFromEntities(users);
	}
}
