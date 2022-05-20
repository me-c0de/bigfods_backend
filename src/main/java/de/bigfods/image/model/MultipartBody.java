package de.bigfods.image.model;

import javax.ws.rs.core.MediaType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jboss.resteasy.annotations.jaxrs.FormParam;
import org.jboss.resteasy.annotations.providers.multipart.PartType;
import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataOutput;

@Getter
@Setter
@NoArgsConstructor
public class MultipartBody extends MultipartFormDataOutput {

  @FormParam("image")
  @PartType(MediaType.APPLICATION_OCTET_STREAM)
  public byte[]  image;

}
