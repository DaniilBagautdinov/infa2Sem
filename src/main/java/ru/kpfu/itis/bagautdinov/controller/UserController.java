package ru.kpfu.itis.bagautdinov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kpfu.itis.bagautdinov.dto.CreateUserDto;
import ru.kpfu.itis.bagautdinov.dto.UserDto;
import ru.kpfu.itis.bagautdinov.helper.PasswordHelper;
import ru.kpfu.itis.bagautdinov.model.User;
import ru.kpfu.itis.bagautdinov.repository.UserRepository;
import ru.kpfu.itis.bagautdinov.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    @ResponseBody
    public Iterable<UserDto> getAll(@RequestParam(value = "name", required = false) Optional<String> name) {
        return name.isEmpty() ? userService.getAll() : userService.getAllByName(name.get());
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public UserDto get(@PathVariable Integer id) {
        return userService.getById(id);
    }

    //    @PostMapping("/user")
    //    @ResponseBody
    //    public UserDto createUser(@Valid @RequestBody CreateUserDto user) {
    //        return userService.signUp(user);
    //    }

    @GetMapping("/user/stepan")
    @ResponseBody
    public Iterable<UserDto> getAllStepan() {
        return userService.getAllStepan();
    }

    public String signUp(@ModelAttribute(name = "user") CreateUserDto userDto, HttpServletRequest request) {
        String url = request.getRequestURL().toString().replace(request.getServletPath(), "");
        userService.signUp(userDto, url);
        return "sign_up_success";
    }

    @GetMapping("/verify")
    public String verify(@Param("code") String code) {
        if (userService.verify(code)) {
            return "verification_success";
        } else {
            return "verification_failed";
        }
    }
}
