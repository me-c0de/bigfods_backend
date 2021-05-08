package de.bigfods.service;

import de.bigfods.data.Cat;
import de.bigfods.data.Image;
import de.bigfods.data.MultipartBody;
import de.bigfods.repository.CatRepository;
import de.bigfods.repository.ImageRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ImageService {

  @Inject
  ImageRepository imageRepository;

  @Inject
  CatRepository catRepository;

  public Image showImage(Long id) {
    Cat cat = catRepository.findById(id);
    return cat.getImage();
  }

  public List<Image> showImages() {
    return imageRepository.findAllCats();
  }

  public Image updateImage(Long id, Image image) {
    imageRepository.update("SELECT * FROM cat WHERE id = " + id, image);
    return image;
  }

  public Image addImage(Long id, MultipartBody body) {
    Image image = new Image();
    image.setData(body.getImage());
    Cat cat = catRepository.findById(id);
    image.setCat(cat);
    imageRepository.persist(image);
    cat.setImage(image);
    catRepository.persist(cat);
    return image;
  }

  public boolean deleteImage(Long id) {
    imageRepository.deleteById(id);
    return true;
  }
}
