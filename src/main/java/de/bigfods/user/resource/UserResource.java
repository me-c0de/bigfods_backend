package de.bigfods.user.resource;

import de.bigfods.user.model.User;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Path("/api")
public class UserResource {

  private final UserService userService;

  @POST
  @Path("/registration")
  @Transactional
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public User register(User user) {
    userService.signUp(user);
    return user;
  }

  @POST
  @Path("/login")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.TEXT_PLAIN)
  public String login(User user) {
    System.out.println(userService.login(user));
    return userService.login(user);
  }
}
