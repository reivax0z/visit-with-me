package reivax.norac.website.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import reivax.norac.website.caches.CityCache;
import reivax.norac.website.dto.CitiesVisitedDTO;

@Path("cities")
public class CitiesRestService {
    @SuppressWarnings("unused")
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public CitiesRestService() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of CitiesRestService
     * @return an instance of CitiesVisitedDTO
     */
    @GET
    @Produces("application/xml")
    public List<CitiesVisitedDTO> getXml() {
        return CityCache.getInstance().getAll();
    }

    /**
     * PUT method for updating or creating an instance of CitiesRestService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(CitiesVisitedDTO content) {
    }

}