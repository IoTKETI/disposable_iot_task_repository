package kr.re.keti.disposable.taskservice.mapper;

import kr.re.keti.disposable.taskservice.category.Category;

import java.util.List;

public interface CategoryMapper {

    Category findOne(String category_id);

    List<Category> findAll();

}
