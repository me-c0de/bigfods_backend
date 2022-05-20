package de.bigfods.user.resource;

import de.bigfods.user.model.User;
import de.bigfods.user.repository.UserRepository;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RequestScoped
public class UserService {

  private final UserRepository userRepository;
  private final TokenService tokenService;


  public User signUp(User user){
    boolean userExists = userRepository
        .findByUsername(user.getUsername())
        .isPresent();

    if (userExists) {
      throw new IllegalStateException("email already taken");
    }

    userRepository.persist(user);

    return user;
  }

  public String login(User user){

    Optional<User> registeredUser = userRepository
        .findByUsername(user.getUsername());

    if(registeredUser.isEmpty() || !user.getPassword().equals(registeredUser.get().getPassword())) {
      throw new WebApplicationException(Response.status(404).entity("No user found or password is incorrect").build());
    }
    return tokenService.generateToken();
  }
}
