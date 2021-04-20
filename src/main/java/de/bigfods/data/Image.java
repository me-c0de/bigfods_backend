package de.bigfods.data;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Image extends PanacheEntity {


  String name;
  String type;
  private byte[] data;
  /*
  @ManyToOne
  Cat cat;
   */


}
