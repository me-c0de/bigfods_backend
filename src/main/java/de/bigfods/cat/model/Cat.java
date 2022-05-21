package de.bigfods.cat.model;


import de.bigfods.image.model.Image;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cat extends PanacheEntity {

  private String name;
  private String description;
  @OneToOne
  @Cascade(CascadeType.MERGE)
  private Image image;
  @OneToMany(fetch = FetchType.EAGER)
  @Cascade(CascadeType.MERGE)
  private Collection<Image> kittenImages;
}
