package de.bigfods.data;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Information extends PanacheEntity {

  @Id
  String key;
  String value;

}
