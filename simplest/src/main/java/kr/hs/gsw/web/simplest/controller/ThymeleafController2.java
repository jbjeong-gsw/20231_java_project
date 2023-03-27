package kr.hs.gsw.web.simplest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/th2")
public class ThymeleafController2 {

    @GetMapping("/basic")
    public String page1(Model model) {

        return "th2/basic";
    }

    @GetMapping("/text")
    public String page2(Model model) {

        model.addAttribute("message",
                "<b>경북</b> <span style='color: red;'>소프트웨어</span> 고등학교");

        return "th2/text";
    }

    @GetMapping("/if")
    public String page3(Model model) {

        model.addAttribute("result", true);
        model.addAttribute("name", "Tom");

        return "th2/if";
    }

    @GetMapping("/each")
    public String page4(Model model) {
        String[] colors = new String[] {
                "빨강", "노랑", "초록", "파랑", "보라"
        };

        List<Writing> list = new ArrayList<>();
        list.add(new Writing("더 글로리", "김은숙", 150));
        list.add(new Writing("헤어질 결심", "박찬욱", 85));
        list.add(new Writing("기생충", "봉준호", 123));
        list.add(new Writing("슬램덩크", "강백호", 55));

        model.addAttribute("colors", colors);
        model.addAttribute("list", list);

        return "th2/each";
    }

    @GetMapping("/layout/home")
    public String layoutHome() {
        return "th2/layout/home";
    }

    @GetMapping("/layout/about")
    public String layoutAbout() {
        return "th2/layout/about";
    }

    public static class Writing {
        public String title;
        public String writer;
        public int hit;

        public Writing(String title, String writer, int hit) {
            this.title = title;
            this.writer = writer;
            this.hit = hit;
        }
    }
}
