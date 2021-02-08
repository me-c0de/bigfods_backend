package de.bigfods.data;


import io.quarkus.hibernate.orm.panache.PanacheEntity;
import java.io.File;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cat extends PanacheEntity {

  private File picture;
  private String name;
  private LocalDateTime birthday;
  private String coatColor;
  @ManyToMany
  @JoinTable(
      name = "family_tree",
      joinColumns = @JoinColumn(name = "kindles"),
      inverseJoinColumns = @JoinColumn(name = "father_mother"))
  private Set<Kindle> kindles;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "cats")
  private Kindle kindle;
  @ManyToMany
  @JoinTable(
      name = "family",
      joinColumns = @JoinColumn(name = "children"),
      inverseJoinColumns = @JoinColumn(name = "parents"))
  private Set<Cat> children;
  @ManyToMany
  private Set<Cat> parents;



  public Cat(){

  }

}
