package kr.hs.gbsw.spring.sec.controller;

import kr.hs.gbsw.spring.sec.domain.Member;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @GetMapping("/member/add")
    public String memberAdd(Model model) {
        return "member/add";
    }

    @PostMapping("/member/add")
    public String memberAdd(@ModelAttribute Member member) {
        LoggerFactory.getLogger(getClass()).info("MEMBER {}", member);


        return "member/add";
    }


    @RequestMapping("/page1")
    public String page1(Model model) {
        return "page1";
    }

    @RequestMapping("/page2")
    public String page2(Model model) {
        return "page2";
    }

    @RequestMapping("/user/detail")
    public String userDetail(Model model) {
        return "user/detail";
    }

}
