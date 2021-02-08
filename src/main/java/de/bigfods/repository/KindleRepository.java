package de.bigfods.repository;

import de.bigfods.data.Kindle;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import java.util.List;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class KindleRepository implements PanacheRepository<Kindle> {

  public List<Kindle> findAllKindels(){
    return findAll().list();
  }

}
