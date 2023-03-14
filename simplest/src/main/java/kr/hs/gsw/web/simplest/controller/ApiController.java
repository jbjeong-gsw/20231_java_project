package kr.hs.gsw.web.simplest.controller;

import kr.hs.gsw.web.simplest.dto.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping("/person1")
    public Person person(@RequestParam("name") String name,
                         @RequestParam("age") int age) {
        Person person = new Person();
        person.setName(name);
        person.setAge(age);

        return person;
    }

    @RequestMapping("/person2")
    public Person person2(@RequestBody Person person) {
        return person;
    }

}
