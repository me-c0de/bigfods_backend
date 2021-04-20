package de.bigfods.service;

import de.bigfods.data.Image;
import de.bigfods.repository.ImageRepository;
import java.util.List;
import javax.inject.Inject;

public class ImageService {

  @Inject
  ImageRepository imageRepository;

  public Image showImage(Long id) {
    return imageRepository.findById(id);
  }

  public List<Image> showImages() {
    return imageRepository.findAllCats();
  }

  public Image updateImage(Long id, Image image) {
    imageRepository.update("SELECT * FROM cat WHERE id = " + id, image);
    return image;
  }

  public Image addImage(Image image) {
    imageRepository.persist(image);
    return image;
  }

  public boolean deleteImage(Long id) {
    imageRepository.deleteById(id);
    return true;
  }
}
