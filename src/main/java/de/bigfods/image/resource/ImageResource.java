package de.bigfods.image.resource;

import de.bigfods.image.model.Image;
import de.bigfods.image.model.MultipartBody;
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
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@Path("/api")
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
  @Path("cat/{id}/image")
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  public byte[] showImage(@PathParam("id") long id){
    return imageService.showImage(id).data;
  }

  @POST
  @Path("cat/{id}/image")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public Image addImage(@PathParam("id") Long id, @MultipartForm MultipartBody body){
    return imageService.addImage(id, body);
  }

  @Path("cat/{id}/image/{id}")
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public Image updateImage(@PathParam("id") Long id, Image image){
    return imageService.updateImage(id, image);
  }

  @Path("image/{id}")
  @DELETE
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Transactional
  public boolean deleteImage(@PathParam("id") Long id){
    return imageService.deleteImage(id);
  }
}
