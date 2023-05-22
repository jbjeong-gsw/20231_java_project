package kr.hs.gbsw.spring.sec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/page1")
    public String page1(Model model) {
        return "page1";
    }

    @RequestMapping("/page2")
    public String page2(Model model) {
        return "page2";
    }

}
