package de.bigfods.image.resource;

import de.bigfods.cat.model.Cat;
import de.bigfods.cat.repo.CatRepository;
import de.bigfods.image.model.Image;
import de.bigfods.image.model.MultipartBody;
import de.bigfods.image.repo.ImageRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ApplicationScoped
public class ImageService {

  private final ImageRepository imageRepository;
  private final CatRepository catRepository;

  public Image showImage(Long id) {
    return imageRepository.findById(id);
  }

  public List<Image> showImages() {
    return imageRepository.findAllCatImages();
  }

  public Image updateImage(Long id, MultipartBody body) {

    System.out.println("executed");
    Image image = imageRepository.findById(id);

    if(image == null){
      image = new Image();
    }

    if(body != null){
      image.setData(body.getImage());
    }

    imageRepository.persist(image);

    return image;
  }

  public Image addImage(MultipartBody body) {

    if(body == null){
     return null; //Todo: Response
    }

    Image image = new Image();
    image.setData(body.getImage());

    imageRepository.persist(image);

    return image;
  }

  public boolean deleteImage(Long id) {
    imageRepository.deleteById(id);
    return true;
  }


}
