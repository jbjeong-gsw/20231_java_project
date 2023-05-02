package kr.hs.gbsw.database.controller;

import kr.hs.gbsw.database.entity.User;
import kr.hs.gbsw.database.repository.UserRepository;
import kr.hs.gbsw.database.service.UserService;
import kr.hs.gbsw.database.service.UserServiceByJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/add")
    public String addUser(Model model) {
        return "user/add";
    }

    @PostMapping("/user/add")
    public String addUser(@ModelAttribute User user) {
        userService.save(user);

        return "redirect:/user/add";
    }

    @RequestMapping("/user/detail")
    public String showUserDetail(Model model,
            @RequestParam(value = "id") int id) {

        User user = userService.getUser(id);
        model.addAttribute("user", user);

        return "user/detail";
    }

    @GetMapping("/user/list")
    public String userList(Model model,
                           @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber,
                           @RequestParam(value="search", defaultValue = "") String search) {
        //List<User> userList = userService.getList();
        //Page<User> userList = userService.getPagingList(pageNumber - 1);
        Page<User> userList = userService.getSearchedList(search, pageNumber - 1);

        model.addAttribute("list", userList);

        return "user/list";
    }
}
