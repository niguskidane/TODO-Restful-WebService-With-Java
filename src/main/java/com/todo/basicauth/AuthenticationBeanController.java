package com.todo.basicauth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AuthenticationBeanController {

    @GetMapping("/basicauth")
    public AuthenticationBean helloWorld(){
        //throw new RuntimeException("Some Error has happned contact Customer Support! ");
        return new AuthenticationBean("You are Authenticated");
    }


}
