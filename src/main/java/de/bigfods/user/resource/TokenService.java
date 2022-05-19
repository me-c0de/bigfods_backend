package de.bigfods.user.resource;

import io.smallrye.jwt.build.Jwt;
import java.util.Arrays;
import java.util.HashSet;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.jwt.Claims;

@NoArgsConstructor
public class TokenService {

  public String generateToken(){
    return Jwt.issuer("BigFods")
            .upn("jdoe@quarkus.io")
            .claim(Claims.birthdate.name(), "2001-07-13")
            .sign();
  }

}
