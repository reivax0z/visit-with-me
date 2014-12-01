package reivax.norac.website.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import reivax.norac.website.caches.CountryCache;
import reivax.norac.website.dto.CountriesVisitedDTO;

@Path("countries")
public class CountriesRestService {
    @SuppressWarnings("unused")
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public CountriesRestService() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of CountriesRestService
     * @return a list of CountriesVisitedDTO
     */
    @GET
    @Produces("application/xml")
    public List<CountriesVisitedDTO> getXml() {
        return CountryCache.getInstance().getAll();
    }

    /**
     * PUT method for updating or creating an instance of CountriesRestService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(CountriesVisitedDTO content) {
    }

}