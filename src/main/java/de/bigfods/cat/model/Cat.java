package de.bigfods.cat.model;


import de.bigfods.image.model.Image;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import javax.persistence.Entity;
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
