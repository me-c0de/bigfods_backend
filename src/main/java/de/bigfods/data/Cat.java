package de.bigfods.data;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Cat extends PanacheEntity {

  public String name;
  public String description;

  @OneToOne
  public Image profile;

  /*
  @ManyToMany
  public List<Image> kittenImages;
   */

  public void setImage(Image profile) {
    this.profile = profile;
  }

  public Image getImage() {
    return profile;
  }
}
