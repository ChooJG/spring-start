package hello.springstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    //정적 파일보다 컨트롤러가 더 우선순위가 높음
    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createForm";
    }


}
