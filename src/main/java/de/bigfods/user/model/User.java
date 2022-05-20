package de.bigfods.user.model;

import de.bigfods.user.util.EncryptedPasswordProvider;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.PasswordType;
import io.quarkus.security.jpa.Username;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User extends PanacheEntityBase {

  @Id
  @Username
  private String username;
  @Password(value = PasswordType.CUSTOM, provider = EncryptedPasswordProvider.class)
  private String password;
  private String firstName;
  private String lastName;
}