package kr.hs.gbsw.database.controller;

import kr.hs.gbsw.database.entity.User;
import kr.hs.gbsw.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("user/add")
    public String addUser(Model model) {
        return "user/add";
    }

    @PostMapping("user/add")
    public String addUser(@ModelAttribute User user) {
        userRepository.save(user);

        return "redirect:/user/add";
    }

}
