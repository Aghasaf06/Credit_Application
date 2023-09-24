package buta.creditapplication.Controller;

import buta.creditapplication.Entity.User;
import buta.creditapplication.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    String fin;

    @GetMapping(path = "/home")
    public String home() {
        return "home";
    }

    @GetMapping(path = "/register")
    public String register() {
        return "register";
    }

    @GetMapping(path = "/login")
    public String login() {
        return "login";
    }

    @PostMapping(path = "/saveUser")
    public String saveUser(@ModelAttribute User user) {
        user.setPassword("12345");
        userService.saveUser(user);
        return "submit";
    }

    @GetMapping(path = "/myAccount")
    public ModelAndView myAccount() {
        User user = userService.getByFin(fin);
        return new ModelAndView("myAccount", "user", user);
    }

    @PostMapping(path = "/loginMyAccount")
    public String loginMyAccount(@RequestParam(name = "fin") String fin, @RequestParam(name = "password") String password) {
        if (userService.loginMyAccount(fin, password)) {
            this.fin = fin;
            return "redirect:/user/myAccount";
        } else {
            return "redirect:/user/login";
        }
    }
}
