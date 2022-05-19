package de.bigfods.user.resource;

import de.bigfods.user.model.User;
import io.quarkus.security.Authenticated;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Path("/api")
public class UserResource {

  private final UserService userService;

  //TokenService service;

  @POST
  @Path("/users")
  @Transactional
  public User register(User user) {
    userService.signUp(user);
    return user;
  }

  @GET
  @Path("/users")
  @Authenticated
  public String login(User user) {
    return userService.login(user);
  }
}
