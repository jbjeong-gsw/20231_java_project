package kr.hs.gbsw.database.controller;

import kr.hs.gbsw.database.entity.User;
import kr.hs.gbsw.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private UserService userService;

    @GetMapping("/user/find-email")
    public User readUser(
        @RequestParam(value = "email") String email) {

        User user = userService.getUser(email);
        return user;
    }

}
