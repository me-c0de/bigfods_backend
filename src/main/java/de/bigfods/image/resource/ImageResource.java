package de.bigfods.image.resource;

import de.bigfods.image.model.Image;
import de.bigfods.image.model.MultipartBody;
import io.quarkus.security.Authenticated;
import java.util.List;
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
import org.jboss.resteasy.annotations.providers.multipart.MultipartForm;

@AllArgsConstructor
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/api")
public class ImageResource {
  private final ImageService imageService;


  @POST
  @Path("images")
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Transactional
  @Authenticated
  public Image addImage(@MultipartForm MultipartBody body){
    return imageService.addImage(body);
  }
  @GET
  @Path("images")
  @Authenticated
  public List<Image> showImages(){
    return imageService.showImages();
  }

  @GET
  @Path("images/{imageId}")
  @Produces(MediaType.APPLICATION_OCTET_STREAM)
  @Authenticated
  public byte[] showImage(@PathParam("imageId") long id){
    return imageService.showImage(id).getData();
  }

  @Path("images/{imageId}")
  @PUT
  @Consumes(MediaType.MULTIPART_FORM_DATA)
  @Transactional
  @Authenticated
  public Image updateImage(@PathParam("imageId") Long id, @MultipartForm MultipartBody body){
    System.out.println("executed");
    return imageService.updateImage(id, body);
  }

  @Path("images/{imageId}")
  @DELETE
  @Transactional
  @Authenticated
  public boolean deleteImage(@PathParam("imageId") Long id){
    return imageService.deleteImage(id);
  }

}
