package app.prog.repository;

import app.prog.model.CategorieEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieRepository extends JpaRepository<CategorieEntity, Integer> {
    CategorieEntity findByName(String Name);
}
