package de.bigfods.service;

import de.bigfods.data.Cat;
import de.bigfods.data.Kindle;
import de.bigfods.repository.CatRepository;
import java.io.File;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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