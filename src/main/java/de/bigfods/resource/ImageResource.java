package de.bigfods.resource;

import de.bigfods.data.Cat;
import de.bigfods.data.Image;
import de.bigfods.service.ImageService;
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

public class ImageResource {

  @Inject
  ImageService imageService;

  @GET
  @Path("/images")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Image> showImages(){
    return imageService.showImages();
  }

  @GET
  @Path("/image/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public Image showImage(@PathParam("id") long id){
    System.out.println("Ich werde ausgeführt");
    return imageService.showImage(id);
  }

  @POST
  @Path("/image")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public Image addImage(Image image){
    return imageService.addImage(image);
  }

  @Path("image/{id}")
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public Image updateImage(@PathParam("id") Long id, Image image){
    return imageService.updateImage(id, image);
  }

  @Path("cat/{id}")
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public boolean deleteCat(@PathParam("id") Long id){
    return imageService.deleteImage(id);
  }
}
