package app.prog.service;

import app.prog.controller.mapper.BookRestMapper;
import app.prog.controller.response.BookResponse;
import app.prog.model.BookEntity;
import app.prog.exception.NotFoundException;
import app.prog.repository.BookRepository;
import app.prog.repository.CategorieRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private final BookRepository repository;
    private final BookRestMapper mapper;
    public List<BookEntity> getBooks() {
        return repository.findAll();
    }

    public List<BookEntity> createBooks(List<BookEntity> toCreate) {
        return repository.saveAll(toCreate);
    }

    public List<BookEntity> updateBooks(List<BookEntity> toUpdate) {
        return repository.saveAll(toUpdate);
    }

    //TODO-3: should I use Integer here or int ? Why ?
    public String deleteBook(Integer id) {
        /*
        TIPS: From the API, the Class Optional<T> is :
        A container object which may or may not contain a non-null value.
        If a value is present, isPresent() returns true.
        If no value is present, the object is considered empty and isPresent() returns false.

        T is the type of the value, for example : here the class type is BookEntity
         */
        BookEntity optional = repository.findById(id).orElseThrow(()-> {throw new NotFoundException("BookEntity." + id + " not found");});
        BookResponse resp = mapper.toRest(optional);
        repository.delete(optional);
        BookEntity actualOpional = mapper.toDomain(resp);


            return "delet id"+ id + "sucsesse";

        /*
        TODO-5 : The exception appears as an internal server error, status 500.
*/
    }
}
