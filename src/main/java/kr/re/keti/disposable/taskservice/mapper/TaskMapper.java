package kr.re.keti.disposable.taskservice.mapper;

import kr.re.keti.disposable.taskservice.task.Task;

import java.util.List;

public interface TaskMapper {

    List<Task> findAll(String id, String category_id,String name);

    Task findOne(int id);

    void save(Task task);

    void delete(int id);
}
