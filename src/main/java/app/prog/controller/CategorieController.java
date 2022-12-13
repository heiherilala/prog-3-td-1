package app.prog.controller;

import app.prog.controller.mapper.CategorieRestMapper;
import app.prog.controller.response.CategorieResponse;
import app.prog.controller.response.CreateCategorieResponse;
import app.prog.controller.response.UpdateCategorieResponse;
import app.prog.model.CategorieEntity;
import app.prog.service.CategorieService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CategorieController {
    private final CategorieService service;
    private final CategorieRestMapper mapper;

    @GetMapping("/Categories")
    public List<CategorieResponse> getCategories() {
        return service.getCategories().stream()
                .map(mapper::toRest)
                .toList();
    }

    @PostMapping("/Categories")
    public List<CategorieResponse> createCategories(@RequestBody List<CreateCategorieResponse> toCreate) {
        List<CategorieEntity> domain = toCreate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.createCategories(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @PutMapping("/Categories")
    public List<CategorieResponse> updateCategories(@RequestBody List<UpdateCategorieResponse> toUpdate) {
        List<CategorieEntity> domain = toUpdate.stream()
                .map(mapper::toDomain)
                .toList();
        return service.updateCategories(domain).stream()
                .map(mapper::toRest)
                .toList();
    }

    @DeleteMapping("/Categories/{CategorieId}")
    public CategorieResponse deleteCategorie(@PathVariable int CategorieId) {
        return mapper.toRest(service.deleteCategorie(CategorieId));
    }
}
