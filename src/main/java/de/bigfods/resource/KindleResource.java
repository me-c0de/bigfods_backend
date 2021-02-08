package de.bigfods.resource;

import de.bigfods.data.Cat;
import de.bigfods.data.Kindle;
import de.bigfods.repository.KindleRepository;
import de.bigfods.service.KindleService;
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

public class KindleResource {

  @Inject
  KindleService kindleService;

  @GET
  @Path("/kindles")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Kindle> showKindles(){
    return kindleService.showKindles();
  }

  @GET
  @Path("/kindle/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Kindle showKindle(@PathParam("id") long id){
    return kindleService.showKindle(id);
  }

  @POST
  @Path("/kindle")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public Kindle addKindle(Kindle kindle){
    return kindleService.addKindle(kindle);
  }

  @Path("kindles/{id}")
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public Kindle updateCar(@PathParam("id") Integer id, Kindle kindle){
    return kindleService.updateKindle(id, kindle);
  }

  @Path("kindles/{id}")
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public boolean deleteKindle(@PathParam("id") Integer id){
    return kindleService.deleteKindle(id);
  }
}
