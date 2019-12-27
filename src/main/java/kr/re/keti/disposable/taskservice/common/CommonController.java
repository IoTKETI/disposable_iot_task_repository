package kr.re.keti.disposable.taskservice.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class CommonController {

    @RequestMapping("")
    public String mainPage(){
        return "main.html";
    }
}
