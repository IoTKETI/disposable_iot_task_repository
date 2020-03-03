package kr.re.keti.disposable.taskservice.deploy;

import kr.re.keti.disposable.taskservice.category.Category;
import kr.re.keti.disposable.taskservice.mapper.CategoryMapper;
import kr.re.keti.disposable.taskservice.mapper.TaskMapper;
import kr.re.keti.disposable.taskservice.task.Task;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Slf4j
@Transactional
public class DeployService {

    private CategoryMapper categoryMapper;
    private TaskMapper taskMapper;
    private List<Category> categories;
    private List<Task> tasks;
    private Category targetService;
    private RestTemplate restTemplate;
    private RetryTemplate retryTemplate;

    @Value("${service.url}")
    private String serviceUrl;

    public DeployService(CategoryMapper categoryMapper, TaskMapper taskMapper, RestTemplate restTemplate, RetryTemplate retryTemplate) {
        this.categoryMapper = categoryMapper;
        this.taskMapper = taskMapper;
        this.restTemplate = restTemplate;
        this.retryTemplate = retryTemplate;
    }

    @PostConstruct
    public void init() {
        categories = categoryMapper.findAll();
        tasks = taskMapper.findAll(null,null,null);
    }

    @Async
    public void deployToCloud(Deploy deploy) {
        kr.re.keti.disposable.taskservice.task.Service targetService = deploy.getService().get(0);
//        List<Task> deployData = getDeployData(deploy, microServiceCategory);
        sendOrder(targetService);
    }
//
    private void sendOrder(kr.re.keti.disposable.taskservice.task.Service service) {

        Order order = new Order(service.getMicroservices(),"서비스로 task 전송", LocalDateTime.now());
        log.debug("order : {}",order);
        try {
            retryTemplate.execute((RetryCallback<Void, Exception>) context -> {
            restTemplate.postForObject(serviceUrl, order, String.class);
            return null;
            });
        } catch (Exception e) {
            log.debug(e.getLocalizedMessage() + "로 retry 실행했음");
        }
    }
//
//    private List<Task> getDeployData(Deploy deploy, Category microServiceCategory) {
//        List<Task> orderTaks = new ArrayList<>();
//        for(kr.re.keti.disposable.taskservice.task.Service targetService : deploy.getService()) {
//            targetTask = getTargetTask(targetTask);
//            Category taskParentCategory = targetTask.getCategory();
//
//            //미리 전체 카테고리목록에서
//            // 해당 카테고리의 id를 가지고 있는 서비스, 마이크로서비스들을 수집
//            if(microServiceCategory == null) {
//                microServiceCategory = getTargetCategory(taskParentCategory);
//                targetService = getTargetCategory(microServiceCategory);
//                getTargetCategory(targetService);
//            }
//
//            //원랜 여기서 서비스 ID 가져와서 해당 서비스에게 명령 줘야함
//            orderTaks.add(targetTask);
//        }
//
//        return orderTaks;
//    }
//
//    private Category getTargetCategory(Category taskCategory) {
//        for (Category category : categories) {
//            if (category.getId().equals(taskCategory.getId())) {
//                taskCategory = category;
//                return new Category();
//            }
//        }
//        new RuntimeException("No matching Category in deploy Data");
//        return null;
//    }
//
//    private Task getTargetTask(Task targetTask) {
//        boolean validation = false;
//        for(Task task : tasks) {
//            if(targetTask.getId() == task.getId()) {
//                targetTask = task;
//                validation = true;
//                break;
//            }
//        }
//        if(validation == false) {
//            new RuntimeException("No matching task in deploy Data");
//        }
//        return targetTask;
//    }
}
