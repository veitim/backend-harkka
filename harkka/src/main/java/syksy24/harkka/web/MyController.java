package syksy24.harkka.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

    @RequestMapping("/index")
    @ResponseBody
    public String showMessage() {
        return "This is the main page";
    }

    @RequestMapping("/contact")
    @ResponseBody
    public String showMessage2() {
        return "This is the contact page";
    }

    @RequestMapping("hello")
    @ResponseBody
    public String showGreeting(@RequestParam (name="name") String firstname, 
        @RequestParam (name="location") String location) {
        return "Welcome to the " + location + " " + firstname + "!";
    }

}
