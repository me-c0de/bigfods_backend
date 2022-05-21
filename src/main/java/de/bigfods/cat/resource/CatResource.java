package de.bigfods.cat.resource;

import de.bigfods.cat.model.Cat;
import io.quarkus.security.Authenticated;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Path("/api")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CatResource {

    private final CatService catService;

    @GET
    @Path("/cats")
    public List<Cat> showCats(){
        return catService.showCats();
    }

    @GET
    @Path("/cats/{id}")
    public Cat showCats(@PathParam("id") long id){
        System.out.println("Ich werde ausgeführt");
        return catService.showCat(id);
    }

    @POST
    @Path("/cats")
    @Transactional
    @Authenticated
    public Cat addCat(Cat cat){
        return catService.addCat(cat);
    }

    @Path("cats/{id}")
    @PUT
    @Transactional
    @Authenticated
    public Cat updateCat(@PathParam("id") Long id, Cat cat){
        return catService.updateCat(id, cat);
    }

    @Path("cats/{id}")
    @DELETE
    @Transactional
    @Authenticated
    public boolean deleteCat(@PathParam("id") Long id){
        return catService.deleteCat(id);
    }
}