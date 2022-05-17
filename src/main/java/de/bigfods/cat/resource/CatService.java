package de.bigfods.cat.resource;

import de.bigfods.cat.model.Cat;
import de.bigfods.cat.repo.CatRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class CatService {

  @Inject
  CatRepository catRepository;

  public Cat showCat(Long id) {
    return catRepository.findById(id);
  }

  public List<Cat> showCats() {
    return catRepository.findAllCats();
  }

  public Cat updateCat(Long id, Cat cat) {
    catRepository.update("SELECT * FROM cat WHERE id = " + id, cat);
    return cat;
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