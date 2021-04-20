package de.bigfods.repository;

import de.bigfods.data.Image;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;

public class ImageRepository implements PanacheRepository<Image> {

  public List<Image> findAllCats(){
    return findAll().list();
  }
}
