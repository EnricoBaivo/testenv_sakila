package studio.baivo.testenv_sakila.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
//dynamic request handler
@Controller
public class HelloController {
    //    Handles request at path party
    @GetMapping("party")
    @ResponseBody
    public String party() {
        return "<script>alert('LETTS GOOOO, PARTY 🥳🎉🎉!')</script>";
    }

    //    Handles request at path goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goobye() {
        return "Hello, Sprint!";
    }


    //    Handels request of the form /hello?name=LaunchCode
    @GetMapping("helloWithQueryParam")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name +"!";
    }

    //    Handels request of the form /hello/LaunchCode
    @GetMapping("Hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }
    @GetMapping("form")
    @ResponseBody
    public String helloForm(){
//        returns html bullshit
        return "<alert>Hello</alert>";

    }

}

