package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam(name = "name", required = true) String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name) {
        // ResponseBody : http 통신 프로토콜에 head와 body가 있는데
        // 응답 body 안에 내용을 넣어주겠다는 의미
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam ("name") String name) {
        // 객체 생성
        Hello hello = new Hello();
        // 객체를 넘김
        hello.setName(name);
        // json으로 반환됨
        return hello;
    }

    static class Hello {
        private String name;

        // 꺼낼 때는 getName
        public String getName() {
            return name;
        }

        // 넣을 때는 setName
        public void setName(String name) {
            this.name = name;
        }
    }
}
