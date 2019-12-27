package kr.re.keti.disposable.taskservice.category;

import kr.re.keti.disposable.taskservice.task.MicroService;
import kr.re.keti.disposable.taskservice.task.Service;
import kr.re.keti.disposable.taskservice.task.Task;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@ToString
public class Category {

    private String id;
    private String name;
    private String type;
    private List<Service> services = new ArrayList<>();
    private List<MicroService> microServices = new ArrayList<>();
    private List<Task> tasks = new ArrayList<>();
    private String useYn;
    private int order;
    private String description;
    private String creator;
    private LocalDateTime createdTime;
    private String updater;
    private LocalDateTime updatedTime;

}
