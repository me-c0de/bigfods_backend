package de.bigfods.cat.resource;

import de.bigfods.cat.model.Cat;
import de.bigfods.cat.repo.CatRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@ApplicationScoped
public class CatService {

  CatRepository catRepository;

  public Cat showCat(Long id) {
    return catRepository.findById(id);
  }

  public List<Cat> showCats() {
    return catRepository.findAllCats();
  }

  public Cat updateCat(Long id, Cat newCat) {
    Cat oldCat = catRepository.findById(id);

    if(oldCat == null || newCat == null ){
      return null;
    }

    oldCat.setName(newCat.getName());
    oldCat.setDescription(newCat.getDescription());

    return oldCat;
  }

  public Cat addCat(Cat cat) {
    catRepository.persist(cat);
    return cat;
  }

  public boolean deleteCat(Long id) {
    catRepository.deleteById(id);
    return true;
  }
}