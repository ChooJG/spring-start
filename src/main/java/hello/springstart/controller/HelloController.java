package hello.springstart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!");
        
        //hello 라는 템플릿 (html 파일) 실행
        return "hello";
    }

    @ResponseBody
    @GetMapping("/hello-static.html")
    public String hello(){
        return "정적 컨텐츠가 아닌 컨트롤러입니다";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("bravo", name);
        return "hello-template";
    }


    @ResponseBody //html body 부분에 return 내용을 직접 넣어주는 어노테이션
    @GetMapping("/hello-string")
    //파라미터 정보 ctrl + p
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @ResponseBody
    @GetMapping("hello-api")
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }


    static class Hello{
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
