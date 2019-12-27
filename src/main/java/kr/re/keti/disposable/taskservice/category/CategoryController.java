package kr.re.keti.disposable.taskservice.category;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
@Slf4j
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }


    @GetMapping("")
    public List<Category> retrieveAllCategory() {
        log.debug("'retrieveAllCategory' has been called");
        return categoryService.retrieveAllCategory();
    }

    @GetMapping("/hierarchy")
    public List<Category> retrieveHierarchyAllCategory() {
        log.debug("'retrieveHierarchyAllCategory' has been called");
        return categoryService.retrieveAllCategory();
    }

    @GetMapping("/hierarchy/{id}")
    public Category retrieveHierarchyTopPartCategory(@PathVariable String id) {
        log.debug("'retrieveHierarchyTopPartCategory' has been called");
        return categoryService.retrieveCategory(id);
    }

}