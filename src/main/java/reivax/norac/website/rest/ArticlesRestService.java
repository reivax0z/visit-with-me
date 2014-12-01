package reivax.norac.website.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;

import reivax.norac.website.caches.ArticleCache;
import reivax.norac.website.dto.ArticleDTO;

@Path("articles")
public class ArticlesRestService {
    @SuppressWarnings("unused")
    @Context
    private UriInfo context;

    /**
     * Default constructor. 
     */
    public ArticlesRestService() {
        // TODO Auto-generated constructor stub
    }

    /**
     * Retrieves representation of an instance of ArticlesRestService
     * @return an instance of ArticleDTO
     */
    @GET
    @Produces("application/xml")
    public List<ArticleDTO> getXml() {
        return ArticleCache.getInstance().getAll();
    }

    /**
     * PUT method for updating or creating an instance of ArticlesRestService
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(ArticleDTO content) {
    }

}