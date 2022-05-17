package de.bigfods.image.model;

import java.util.Arrays;
import javax.ws.rs.core.MediaType;
import org.jboss.resteasy.annotations.jaxrs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;

public class MultipartBody extends MultipartFormDataOutput {

  public MultipartBody() {
  }

  @FormParam("image")
  @PartType(MediaType.APPLICATION_OCTET_STREAM)
  public byte[]  image;

  public byte[] getImage() {
    return image;
  }

  public void setImage(byte[] image) {
    this.image = image;
  }


  @Override
  public String toString() {
    return "MultipartBody{" +
        "image=" + Arrays.toString(image) +
        '}';
  }
}
