package de.bigfods.service;

import de.bigfods.data.Kindle;
import de.bigfods.repository.KindleRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class KindleService {

  @Inject
  KindleRepository kindleRepository;

  public Kindle showKindle(long id){
    return kindleRepository.findById(id);
  }

  public List<Kindle> showKindles(){
    return kindleRepository.findAllKindels();
  }

  public Kindle updateKindle(Integer id, Kindle kindle){
     kindleRepository.update("SELECT * FROM cat WHERE id = " + id, kindle);
     return kindle;
  }

  public Kindle addKindle(Kindle kindle){
    kindle.persist();
    return kindle;
  }

  public boolean deleteKindle(Integer id){
    kindleRepository.delete("id", id);
    return true;
  }

}
