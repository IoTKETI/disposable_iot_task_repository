package kr.re.keti.disposable.taskservice.deploy;

import kr.re.keti.disposable.taskservice.task.Service;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@ToString
public class Deploy {

    private String id;
    private List<Service> service;
    private String name;
    private String description;
    private String creator;
    private LocalDateTime createdTime;

}
