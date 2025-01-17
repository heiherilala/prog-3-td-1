package app.prog.controller.response;

import app.prog.model.CategorieEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class BookResponse {
    private int id;
    private String author;
    private String title;
    private List<CategorieEntity> categorie;
    private boolean hasAuthor;
}
