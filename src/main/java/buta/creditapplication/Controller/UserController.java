package buta.creditapplication.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/user")
public class UserController {

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
}
