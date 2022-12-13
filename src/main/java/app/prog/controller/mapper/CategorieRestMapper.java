package app.prog.controller.mapper;

import app.prog.controller.response.CategorieResponse;
import app.prog.controller.response.CreateCategorieResponse;
import app.prog.controller.response.UpdateCategorieResponse;
import app.prog.model.CategorieEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class CategorieRestMapper {
    public CategorieResponse toRest(CategorieEntity domain) {
        return CategorieResponse.builder()
                .id(domain.getId())
                .name(domain.getName())
                .build();
    }

    public CategorieEntity toDomain(CreateCategorieResponse rest) {
        return CategorieEntity.builder()
                .name(rest.getName())
                .build();
    }

    public CategorieEntity toDomain(CategorieResponse rest) {
        return CategorieEntity.builder()
                .id(rest.getId())
                .name(rest.getName())
                .build();
    }
    public CategorieEntity toDomain(UpdateCategorieResponse rest) {
        return CategorieEntity.builder()
                .id(rest.getId())
                .name(rest.getName())
                .build();
    }

}
