package kr.re.keti.disposable.taskservice.deploy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/deployService")
@Slf4j
public class DeployController {

    private DeployService deployService;

    public DeployController(DeployService deployService) {
        this.deployService = deployService;
    }

    @PostMapping("/task")
    public void deploy(@RequestBody Deploy deploy) {
        log.debug("'deploy' has been called");
        System.out.println(deploy.toString());
        deployService.deployToCloud(deploy);
    }

}
