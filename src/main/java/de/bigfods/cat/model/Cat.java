package de.bigfods.cat.model;


import de.bigfods.image.model.Image;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Cat extends PanacheEntity {

  public String name;
  public String description;

  @OneToOne
  @Cascade(CascadeType.ALL)
  public Image profile;

  /*@ManyToMany
  public List<Image> kittenImages;


   */
  public void setImage(Image profile) {
    this.profile = profile;
  }

  public Image getImage() {
    return profile;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Image getProfile() {
    return profile;
  }

  public void setProfile(Image profile) {
    this.profile = profile;
  }

  /*


  public List<Image> getKittenImages() {
    return kittenImages;
  }

  public void setKittenImages(List<Image> kittenImages) {
    this.kittenImages = kittenImages;
  }

   */
}
