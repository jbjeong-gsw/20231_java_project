package kr.hs.gsw.web.simplest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(HttpServletRequest request,
                        Model model,
                        @RequestParam(value = "name", required = false) String name,
                        @RequestParam(value = "count", required = false) int count,
                        @RequestParam(value = "hobby", defaultValue = "reading") String hobby) {
        /*
        String hobby1 = request.getParameter("hobby");
        if (hobby1 == null) {
            hobby1 = "reading";
        }

        String sCount = request.getParameter("count");
        int count1 = 0;
        try {
            count1 = Integer.parseInt(sCount);
        } catch (NumberFormatException ne) {

        }
         */

        System.out.println("Name : " + name);
        System.out.println("Count : " + count);
        System.out.println("Hobby : " + hobby);

        model.addAttribute("name", name);
        model.addAttribute("count", count);

        return "index";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
