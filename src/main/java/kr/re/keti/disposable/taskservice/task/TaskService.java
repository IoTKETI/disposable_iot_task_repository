package kr.re.keti.disposable.taskservice.task;

import kr.re.keti.disposable.taskservice.mapper.TaskMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private TaskMapper taskMapper;

    public TaskService(TaskMapper taskMapper) {
        this.taskMapper = taskMapper;
    }

    public List<Task> getAllTasks(String id, String category_id, String name) {
        return taskMapper.findAll(id,category_id,name);
    }

    public Task getTask(int id) {
        return taskMapper.findOne(id);
    }

    public void createTask(Task task) {
        taskMapper.save(task);
    }

    public void deleteTask(int id) {
        taskMapper.delete(id);
    }
}
