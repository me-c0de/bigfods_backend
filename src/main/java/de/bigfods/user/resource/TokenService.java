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
        .subject("Admin - Verification")
        .upn(user.getUsername())
        .sign();
    return token;
  }

}
