package kr.hs.gsw.web.simplest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/th1")
public class ThymeleafController1 {

    @GetMapping("/basic")
    public String page1(Model model) {
        return "th1/basic";
    }

    @GetMapping("/text")
    public String page2(Model model) {

        model.addAttribute("message",
                "<b>경북</b> <span style='color: red;'>소프트웨어</span> 고등학교");
        model.addAttribute("now", new Date());

        return "th1/text";
    }

    @GetMapping("/if")
    public String page3(Model model) {

        model.addAttribute("result", false);
        model.addAttribute("name", "Tom");

        return "th1/if";
    }

    @GetMapping("/each")
    public String page4(Model model) {
        String[] colors = new String[] {
                "빨간색", "노란색", "초록색", "파란색"
        };

        List<Writing> writings = new ArrayList<>();
        writings.add(new Writing("안녕", "박민혁", 12));
        writings.add(new Writing("멍충아", "김동혁", 20));
        writings.add(new Writing("Hello", "Jason", 2));

        model.addAttribute("colors", colors);
        model.addAttribute("list", writings);

        return "th1/each";
    }

    @GetMapping("/layout/home")
    public String layoutHome() {
        return "th1/d0327/home";
    }

    @GetMapping("/layout/about")
    public String layoutAbout() {
        return "th1/d0327/about";
    }


    public static class Writing {
        private String title;
        public String writer;
        public int hit;

        public Writing(String title, String writer, int hit) {
            this.title = title;
            this.writer = writer;
            this.hit = hit;
        }

        public String getTitle() {
            return title;
        }
    }

}
