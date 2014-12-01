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

import reivax.norac.website.caches.CountryCache;
import reivax.norac.website.caches.FlickrPhotoCache;
import reivax.norac.website.dto.ArticleDTO;
import reivax.norac.website.dto.ArticlePartDTO;
import reivax.norac.website.dto.CitiesVisitedDTO;
import reivax.norac.website.dto.CountriesVisitedDTO;
import reivax.norac.website.dto.TopFiveDTO;
import reivax.norac.website.dto.VideoDTO;
import reivax.norac.website.service.WebSiteEJB;
import reivax.norac.website.util.CommonsUtils;
import reivax.norac.website.utilities.FlickrHelper;
import reivax.norac.website.utilities.Utils;

/**
 * Servlet implementation class AddArticlePreviewServlet
 */
@WebServlet(name="/AddCityPreviewServlet", urlPatterns={"/AddCityPreviewAction"})
public class AddCityPreviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddCityPreviewServlet() {
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
		String city_name = request.getParameter("city_name");
		String city_lat = request.getParameter("city_lat");
		String city_long = request.getParameter("city_long");
		String did_you_know = request.getParameter("did_you_know");
		String info = request.getParameter("info");
		String area = request.getParameter("area");
		String established = request.getParameter("established");
		String languages = request.getParameter("languages");
		String currency = request.getParameter("currency");
		String population = request.getParameter("population");
		String timezone = request.getParameter("timezone");
		String country = request.getParameter("country");
		
		
		ArrayList<VideoDTO> videos = new ArrayList<VideoDTO>();
		for(int i=0; i<2; i++){
			String videoName = request.getParameter("video_name_"+i);
			String videoDesc = request.getParameter("video_desc_"+i);
			String videoUrl = request.getParameter("video_url_"+i);
			String id = request.getParameter("video_id_"+i);
			if(videoName != null && !videoName.isEmpty()){
				VideoDTO dto = new VideoDTO();
				dto.setName(videoName);
				dto.setLink(videoUrl);
				dto.setDescription(videoDesc);
				dto.setId(Integer.parseInt(id));
				videos.add(dto);
			}
		}
		
		ArrayList<TopFiveDTO> topFive = new ArrayList<TopFiveDTO>();
		for(int i=0; i<5; i++){
			String topName = request.getParameter("top_name_"+i);
			String inBrief = request.getParameter("top_brief_"+i);
			String topInfo = request.getParameter("top_info_"+i);
			String id = request.getParameter("top_id_"+i);
			if(topName != null && !topName.isEmpty()){
				TopFiveDTO dto = new TopFiveDTO();
				dto.setName(topName);
				dto.setInbrief(inBrief);
				dto.setDescription(topInfo);
				dto.setId(Integer.parseInt(id));
				topFive.add(dto);
			}
		}

		
		// Get back all the countries from DB
		List<CountriesVisitedDTO> countries = CountryCache.getInstance().getAll();
		Map<String, CountriesVisitedDTO> countriesMap = CommonsUtils.getCountriesMapByName(countries);

		if(city_name != null){

			CitiesVisitedDTO dto = new CitiesVisitedDTO();
			dto.setArea(Double.valueOf(area));
			dto.setCountryID(countriesMap.get(country).getId());
			dto.setCurrency(currency);
			dto.setDidYouKnow(did_you_know);
			dto.setEstablished(established);
			dto.setInfo(info);
			dto.setLanguages(languages);
			dto.setLatitude(Double.valueOf(city_lat));
			dto.setLongitude(Double.valueOf(city_long));
			dto.setName(city_name);
			dto.setPopulation(population);
			dto.setTimezone(timezone);
			dto.setTopFives(topFive);
			dto.setVideos(videos);
			dto.setPhotosList(FlickrPhotoCache.getInstance().getAll().get(dto.getName().toLowerCase()));

			if(request.getSession().getAttribute("newCity") != null){
				CitiesVisitedDTO preDto = (CitiesVisitedDTO) request.getSession().getAttribute("newCity");
				dto.setId(preDto.getId());
			}

			request.getSession().setAttribute("newCity", dto);
			request.getSession().setAttribute("isEditMode", Boolean.TRUE);
		}

		// Forward the info to the appropriate JSP
		request.setAttribute("countries", countries);

		request.getRequestDispatcher("jsp/DisplayOneCityReal.jsp").forward(request, response);
	}

}
