package app.prog.service;


import app.prog.exception.NotFoundException;
import app.prog.model.CategorieEntity;
import app.prog.repository.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategorieService {
    private final CategorieRepository repository;

    public List<CategorieEntity> getCategories() {
        return repository.findAll();
    }

    public List<CategorieEntity> createCategories(List<CategorieEntity> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<CategorieEntity> updateCategories(List<CategorieEntity> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    public CategorieEntity deleteCategorie(int id) {
        Optional<CategorieEntity> optional = repository.findById(id);
        if (optional.isPresent()) {
            repository.delete(optional.get());
            return optional.get();
        } else {
        /*
        TODO-5 : The exception appears as an internal server error, status 500.
        We all know that the appropriate error status is the 404 Not Found.
        Any solution to do this ?
        These links may help you :
        Link 1 : https://www.baeldung.com/spring-response-entity
        Link 2 : https://www.baeldung.com/exception-handling-for-rest-with-spring
         */
            throw new NotFoundException("CategorieEntity. "+ " " + id + " not found");
        }
    }
}
