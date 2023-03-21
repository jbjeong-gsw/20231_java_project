package kr.hs.gsw.web.simplest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafStudyController {

    @GetMapping("/text")
    public String page1(Model model) {

        model.addAttribute("message", "경북소프트웨어고등학교");
        model.addAttribute("htmlText", "<b>봄</b>이 왔어요.");

        return "thymeleaf/text";
    }

    @GetMapping("/if")
    public String page2(Model model) {

        model.addAttribute("result", true);
        model.addAttribute("success", false);

        return "thymeleaf/if";
    }

    @GetMapping("/each")
    public String page3(Model model) {
        List<Person> list = new ArrayList<>();
        list.add(new Person("손흥민", 30, "남자"));
        list.add(new Person("김연아", 32, "여자"));
        list.add(new Person("장미란", 39, "여자"));
        list.add(new Person("황선우", 19, "남자"));

        model.addAttribute("list", list);

        return "thymeleaf/each";
    }

    public static class Person {
        String name;
        int age;
        String gender;

        Person(String name, int age, String gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getGender() {
            return gender;
        }
    }
}
