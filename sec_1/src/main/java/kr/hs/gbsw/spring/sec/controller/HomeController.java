package kr.hs.gbsw.spring.sec.controller;

import kr.hs.gbsw.spring.sec.domain.Member;
import kr.hs.gbsw.spring.sec.domain.SimpleUserDetails;
import kr.hs.gbsw.spring.sec.service.MemberService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @Autowired
    private MemberService memberService;

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

        memberService.addMember(member);

        return "redirect:/";
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
    public String userDetail(Model model, Authentication authentication) {
        LoggerFactory.getLogger(getClass()).debug("Authentication {}", authentication.toString());
        SimpleUserDetails simpleUserDetails = (SimpleUserDetails) authentication.getPrincipal();
        Member member = simpleUserDetails.getMember();

        member.setPassword(null);

        //authentication.getPrincipal();
        model.addAttribute("member", member);

        return "user/detail";
    }


    @GetMapping("note")
    public String note(Model model, @RequestParam("aaa") String aaa) {
        model.addAttribute("content", "<b>경북소프트웨어고등학교<b>");

        return "note";
    }



}
