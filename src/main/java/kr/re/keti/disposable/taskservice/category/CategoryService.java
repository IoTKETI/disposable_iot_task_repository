package kr.re.keti.disposable.taskservice.category;

import kr.re.keti.disposable.taskservice.mapper.CategoryMapper;
import kr.re.keti.disposable.taskservice.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryMapper categoryMapper;
    private TaskMapper taskMapper;

    public CategoryService(CategoryMapper categoryMapper, TaskMapper taskMapper) {
        this.categoryMapper = categoryMapper;
        this.taskMapper = taskMapper;
    }

    public List<Category> retrieveAllCategory() {
        List<Category> all = categoryMapper.findAll();
        all.get(2).setTasks(taskMapper.findAll(null,null,null));
        return all;
    }

    public Category retrieveCategory(String id) {
        return categoryMapper.findOne(id);
    }

}
