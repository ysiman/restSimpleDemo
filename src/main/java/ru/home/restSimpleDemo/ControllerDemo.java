package ru.home.restSimpleDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.home.restSimpleDemo.Errors.DemoException;

@RestController
public class ControllerDemo {
    @RequestMapping("/demo")
    public String hello(){
        Boolean b = false;
        if (b == false){
            throw new DemoException("Demo exception");
        }
        return "Hello from rest controller!";
    }
}
