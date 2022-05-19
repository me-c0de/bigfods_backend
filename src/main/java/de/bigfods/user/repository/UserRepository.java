package de.bigfods.user.repository;

import de.bigfods.user.model.User;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import java.util.Optional;

public interface UserRepository extends PanacheRepositoryBase<User, String> {

  Optional<User> findByUsername(String email);

}
