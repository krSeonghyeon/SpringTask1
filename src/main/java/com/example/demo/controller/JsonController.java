package com.example.demo.controller;

import com.example.demo.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class JsonController {

    @GetMapping("/json")
    @ResponseBody
    public Person getJson() {
        Person person = new Person();
        person.setName("김성현");
        person.setAge(25);

        return person;
    }
}
