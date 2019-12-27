package kr.re.keti.disposable.taskservice.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tasks")
@Slf4j
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }



    @GetMapping("")
    public List<Task> selectAllTask(@RequestParam(required = false) String id,
                                    @RequestParam(required = false) String category,
                                    @RequestParam(required = false) String name){
        log.debug("'selectAllTask' has been called");
        return taskService.getAllTasks(id,category,name);
    }

    @GetMapping("/{id}")
    public Task selectTask(@PathVariable int id) {
        log.debug("'selectTask' has been called");
        return taskService.getTask(id);
    }

    @PostMapping("")
    public void createTask(Task task) {
        log.debug("'createTask' has been called");
        taskService.createTask(task);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable int id) {
        log.debug("'deleteTask' has been called");
        taskService.deleteTask(id);
    }

    @PostMapping("/{id}/outputParameter")
    public void createOutPutParameter(@PathVariable int id, OutPutParameter outPutParameter) {
        log.debug("'createOutPutParameter' has been called");
    }

    @PostMapping("/{id}/staticParameter")
    public void createStaticParameter(@PathVariable int id, StaticParameter staticParameter) {
        log.debug("'createStaticParameter' has been called");
    }

    @PostMapping("/{id}/flexibleParameter")
    public void createFlexibleParameter(@PathVariable int id, FlexibleParameter flexibleParameter) {
        log.debug("'createFlexibleParameter' has been called");
    }
}
