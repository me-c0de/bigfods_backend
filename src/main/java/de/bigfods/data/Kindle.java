package de.bigfods.data;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.io.File;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Kindle extends PanacheEntity{

  private File kindlePictures;
  LocalDateTime localDateTime;
  @ManyToMany
  private Set<Cat> mother_father;
  @OneToMany(fetch = FetchType.LAZY, mappedBy = "kindle")
  private Set<Cat> cats;

  public Kindle(){

  }
}
