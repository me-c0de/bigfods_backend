package de.bigfods.image.model;

import de.bigfods.cat.model.Cat;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Image extends PanacheEntity {

  //image bytes can have large lengths so we specify a value
  //which is more than the default length for picByte column
  @Column(name = "data", length = 100000)
  public byte[] data;
  @OneToOne
  public Cat cat;

}
