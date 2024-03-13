package hello.springstart.controller;

import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        
        //hello 라는 템플릿 (html 파일) 실행
        return "hello";
    }
}
