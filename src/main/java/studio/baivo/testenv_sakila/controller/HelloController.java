package studio.baivo.testenv_sakila.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    //    Handles request at path hello
    @GetMapping("hello")
    @ResponseBody
    public String hello() {
        return "Hello, Sprint!";
    }


    @GetMapping("goodbye")
    @ResponseBody
    public String goobye() {
        return "Hello, Sprint!";
    }


    //    Handels request of the form /hello?name=LaunchCode
    @GetMapping("hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, Sprint!";
    }


}

