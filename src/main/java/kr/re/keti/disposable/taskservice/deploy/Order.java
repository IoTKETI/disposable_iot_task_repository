package kr.re.keti.disposable.taskservice.deploy;

import kr.re.keti.disposable.taskservice.task.MicroService;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;


@Getter
public class Order {
    private List<MicroService> microServices;
    private String description;
    private LocalDateTime createdAt;

    public Order(List<MicroService> microServices, String description, LocalDateTime createdAt) {
        this.microServices = microServices;
        this.description = description;
        this.createdAt = createdAt;
    }
}
