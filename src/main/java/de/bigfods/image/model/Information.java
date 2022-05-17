package de.bigfods.image.model;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Information extends PanacheEntityBase {

  @Id
  String key;
  String value;

}
