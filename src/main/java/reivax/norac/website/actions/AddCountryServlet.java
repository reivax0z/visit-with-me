package reivax.norac.website.actions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reivax.norac.website.caches.CountryCache;
import reivax.norac.website.caches.FlickrPhotoCache;
import reivax.norac.website.dto.CountriesVisitedDTO;
import reivax.norac.website.dto.MustSeeDTO;
import reivax.norac.website.dto.TopFiveDTO;
import reivax.norac.website.service.WebSiteEJB;
import reivax.norac.website.util.CommonsUtils;

/**
 * Servlet implementation class AddCountryServlet
 */
@WebServlet(name="/AddCountry", urlPatterns={"/AddCountryAction"})
public class AddCountryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	@EJB 
	WebSiteEJB countriesEJB;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddCountryServlet() {
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
		String name = request.getParameter("name");
		String info = request.getParameter("info");
		String iso = request.getParameter("iso");
		String lat = request.getParameter("latitude");
		String lon = request.getParameter("longitude");
		
		ArrayList<MustSeeDTO> topSee = new ArrayList<MustSeeDTO>();
		for(int i=0; i<10; i++){
			String topName = request.getParameter("top_name_"+i);
			String inBrief = request.getParameter("top_brief_"+i);
			String topInfo = request.getParameter("top_info_"+i);
			String id = request.getParameter("top_id_"+i);
			if(topName != null && !topName.isEmpty()){
				MustSeeDTO dto = new MustSeeDTO();
				dto.setName(topName);
				dto.setInbrief(inBrief);
				dto.setDescription(topInfo);
				dto.setId(Integer.parseInt(id));
				topSee.add(dto);
			}
		}

		CountriesVisitedDTO editCountry = (CountriesVisitedDTO) request.getSession().getAttribute("editCountry");
		
		if(name != null && info != null){
			CountriesVisitedDTO dto = new CountriesVisitedDTO();
			dto.setInfo(info);
			dto.setName(name);
			dto.setIso(iso);
			dto.setLatitude(Double.valueOf(lat));
			dto.setLongitude(Double.valueOf(lon));
			dto.setMustSees(topSee);
			dto.setPhotosList(FlickrPhotoCache.getInstance().getAll().get(dto.getName().toLowerCase()));

			if(editCountry != null){
				dto.setId(editCountry.getId());
				dto.setCities(editCountry.getCities());
				CountryCache.getInstance().update(dto);
			} else{
				CountryCache.getInstance().add(dto);
			}
		}
		
		CommonsUtils.cleanSession(request);
		
		request.getRequestDispatcher("Home").forward(request, response);
	}

}
