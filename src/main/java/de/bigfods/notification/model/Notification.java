package de.bigfods.notification.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Notification extends PanacheEntity {

  private String subject;
  private String message;
  private LocalDateTime date;

 /* @OneToOne
  @Cascade(CascadeType.ALL)
  private Image image;


  */
}
