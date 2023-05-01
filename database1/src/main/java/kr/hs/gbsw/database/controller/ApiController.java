package kr.hs.gbsw.database.controller;

import kr.hs.gbsw.database.entity.User;
import kr.hs.gbsw.database.repository.UserRepository;
import kr.hs.gbsw.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/user/list")
    public Page<User> userList(
            @RequestParam(value = "pageNumber", defaultValue = "1") int pageNumber) {
        return userService.getPagingList(pageNumber);
    }

    @GetMapping("/user/list2")
    public List<User> userList2(
            @RequestParam(value = "userName", defaultValue = "") String userName) {
        List<User> list = userRepository.getListByJPQL(userName);
        return list;
    }

}
