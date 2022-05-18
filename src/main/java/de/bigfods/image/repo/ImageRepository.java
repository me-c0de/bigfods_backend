package de.bigfods.image.repo;

import de.bigfods.image.model.Image;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ImageRepository implements PanacheRepository<Image> {

  public List<Image> findAllCatImages(){
    return findAll().list();
  }
}
