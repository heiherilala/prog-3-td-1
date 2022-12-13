package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.BookEntity;
import app.prog.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@AllArgsConstructor
public class BookRestMapper {
    private final AuthorRepository repository;
    private final CategorieRestMapper categorieRestMapper;

    public BookResponse toRest(BookEntity domain) {
        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .author(domain.getAuthor().getName())
                .hasAuthor(domain.hasAuthor())
                .categorie(domain.getCategorie())
                .build();
    }

    public BookEntity toDomain(CreateBookResponse rest) {
        return BookEntity.builder()
                .author(repository.findByName(rest.getAuthor()))
                .title(rest.getTitle())
                .categorie(rest.getCategorie())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }

    public BookEntity toDomain(UpdateBookResponse rest) {
        return BookEntity.builder()
                .id(rest.getId())
                .author(repository.findByName(rest.getAuthor()))
                .title(rest.getTitle())
                .categorie(rest.getCategorie())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }

    public BookEntity toDomain(BookResponse rest) {
        return BookEntity.builder()
                .id(rest.getId())
                .author(repository.findByName(rest.getAuthor()))
                .title(rest.getTitle())
                .categorie(rest.getCategorie())
                .pageNumber(0)
                .build();
    }
}
