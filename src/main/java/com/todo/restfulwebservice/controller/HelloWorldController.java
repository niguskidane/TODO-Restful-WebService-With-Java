package com.todo.restfulwebservice.controller;

import com.todo.restfulwebservice.model.HelloWorldBean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

    @GetMapping("/hello")
    public HelloWorldBean helloWorld(){
        //throw new RuntimeException("Some Error has happned contact Customer Support! ");
        return new HelloWorldBean("Hello Angular i am coming");
    }

    @GetMapping("/hello/{name}")
    public HelloWorldBean helloWorldPath(@PathVariable String name){
        return new HelloWorldBean("Hello : "+name+" welcome to Angular!");
    }
}
