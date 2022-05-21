package de.bigfods.user.resource;

import de.bigfods.user.model.User;
import io.smallrye.jwt.build.Jwt;
import java.time.LocalDateTime;
import javax.enterprise.context.RequestScoped;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.jwt.Claim;

@NoArgsConstructor
@RequestScoped
public class TokenService {

  public String generateToken(User user) {
    String token = Jwt
        .subject(user.getUsername())
        .upn(user.getUsername())
        .groups("admin")
        .expiresIn(86400L)
        .sign();
    return token;
  }

}
