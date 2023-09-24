package buta.creditapplication.Controller;

import buta.creditapplication.Entity.Credit;
import buta.creditapplication.Entity.User;
import buta.creditapplication.Service.CreditService;
import buta.creditapplication.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/user")
public class UserController {

    private final UserService userService;
    private final CreditService creditService;

    public UserController(UserService userService, CreditService creditService) {
        this.userService = userService;
        this.creditService = creditService;
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
        user.setPassword("06102002");
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
            return "incorrect";
        }
    }

    @GetMapping(path = "/changePassword")
    public String changePassword() {
        return "changePassword";
    }

    @PostMapping(path = "/newPassword")
    public String newPassword(@RequestParam(name = "fin") String fin, @RequestParam(name = "password") String password) {
        User user = userService.getByFin(fin);
        if (user == null) {
            return "incorrectFin";
        } else {
            userService.changePassword(fin, password);
            return "login";
        }
    }

    @GetMapping(path = "/calculator")
    public String calculator() {
        return "calculator";
    }

    Credit credit;

    @PostMapping(path = "/saveCredit")
    public void saveCredit(@ModelAttribute Credit credit) {
        creditService.saveCredit(credit);
        this.credit = credit;
    }

    @GetMapping(path = "/creditTable")
    public ModelAndView creditTable(Credit credit) {
        credit = this.credit;
        return new ModelAndView("creditTable", "credit", credit);
    }
}
