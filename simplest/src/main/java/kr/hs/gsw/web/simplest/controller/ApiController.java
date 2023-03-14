package kr.hs.gsw.web.simplest.controller;

import kr.hs.gsw.web.simplest.dto.Person;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    //@RequestMapping(value = "/person2", consumes = {"application/x-www-form-urlencoded"})
    @RequestMapping(value = "/person2")
    public Person person2(@ModelAttribute  Person person) {
        LoggerFactory.getLogger(getClass()).info("Person : " + person);
        return person;
    }

}
