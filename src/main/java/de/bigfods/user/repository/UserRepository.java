package de.bigfods.user.repository;

import de.bigfods.user.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class UserRepository implements PanacheRepositoryBase<User, String> {
  public Optional<User> findByUsername(String username) {
    return find("username", username).firstResultOptional();
  }
}
