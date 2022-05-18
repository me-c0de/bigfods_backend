package de.bigfods.image.resource;

import de.bigfods.image.model.Image;
import de.bigfods.image.model.MultipartBody;
import java.util.List;
import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("/api")
public class ImageResource {

  @Inject
  ImageService imageService;

  @GET
  @Path("images")
  @Produces(MediaType.APPLICATION_JSON)
  public List<Image> showImages(){
    return imageService.showImages();
  }


  @Path("images/{imageId}")
  @PUT
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public Image updateImage(@PathParam("imageId") Long id, @MultipartForm MultipartBody body){
    System.out.println("executed");
    return imageService.updateImage(id, body);
  }

  @Path("images/{imageId}")
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public boolean deleteImage(@PathParam("imageId") Long id){
    return imageService.deleteImage(id);
  }

}
