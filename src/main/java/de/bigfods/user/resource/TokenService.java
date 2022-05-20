package de.bigfods.user.resource;

import io.smallrye.jwt.build.Jwt;
import javax.enterprise.context.RequestScoped;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.jwt.Claims;

@NoArgsConstructor
@RequestScoped
public class TokenService {

  public String generateToken(){
    return Jwt.issuer("BigFods")
            .upn("bigfods@bigfods.de")
            .claim(Claims.birthdate.name(), "2001-07-13")
            .sign();
  }

}
