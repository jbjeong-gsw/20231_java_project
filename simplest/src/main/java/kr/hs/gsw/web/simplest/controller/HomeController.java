package kr.hs.gsw.web.simplest.controller;

import kr.hs.gsw.web.simplest.dto.Weather;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/big")
    public String big(Model model,
                      @RequestParam("op1") int op1,
                      @RequestParam("op2") int op2) {
        System.out.println("op1 : " + op1);
        System.out.println("op2 : " + op2);

        int big = (op1 > op2) ? op1 : op2;

        model.addAttribute("op1", op1);
        model.addAttribute("op2", op2);
        model.addAttribute("big", big);

        return "big";
    }

    @RequestMapping("white-day")
    public String whiteDay(
            Model model,
            @RequestParam(value = "lover", defaultValue = "Mom") String lover,
            @RequestParam(value = "gift", required = false) String gift
    ) {

        model.addAttribute("lover", lover);
        model.addAttribute("gift", gift);

        return "whiteDay";
    }

    @RequestMapping("/aaa")
    public String index1(HttpServletRequest request,
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

    @RequestMapping("/spring/{count}/{name}")
    public String spring(Model model,
                         @PathVariable("count") int count,
                         @PathVariable("name") String name) {

        model.addAttribute("name", name);
        model.addAttribute("count", count);

        return "index";
    }

    @RequestMapping("/form1")
    public String form1() {
        return "form1";
    }

    @RequestMapping("/weather")
    public String weather(Model model,
            @RequestParam(value = "name") String name,
            @ModelAttribute Weather weather) {

        model.addAttribute("name", name);
        model.addAttribute("weather", weather);

        return "weather";
    }

}
