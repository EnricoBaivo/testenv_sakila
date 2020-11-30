package studio.baivo.testenv_sakila.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

//dynamic request handler
@Controller
// globally set up Response body
@ResponseBody
// every Request lives under root/trolling/...
@RequestMapping(path="trolling")
public class HelloController {

    //    Handles request at path party
//    @GetMapping("party")
//    @ResponseBody
//     public String party() {
//        return "<script>alert('LETTS GOOOO, PARTY 🥳🎉🎉!')</script>";
//    }

    //    Handles request at path goodbye
    @GetMapping("goodbye")
//    @ResponseBody
    public String goobye() {
        return "Hello, Sprint!";
    }

    //    Handels request of the form /hello?name=LaunchCode
    @GetMapping("helloWithQueryParam")
//    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //    Handels request of the form /hello/LaunchCode
    @GetMapping("Hello/{name}")
//    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    //    Handels both get and post request
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    //   @ResponseBody
    public String helloRequestMapping(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    //    Handels both get and post request uses Dynamic Templates and The Model
    @RequestMapping(value = "party", method = {RequestMethod.GET, RequestMethod.POST})
    //   @ResponseBody
    public String partyRequestMappingModel(@RequestParam String name, Model model) {

        String party = "Hello, " + name + "Let do a party!";
        model.addAttribute("party", party);
        return "indexTemplate";
    }

    @GetMapping("form")
//    @ResponseBody
    public String helloForm() {
//        returns html bullshit
        return "<script>alert('Hello');</script>";

    }



}

