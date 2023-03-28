package com.evoter;

import com.evoter.user.dto.UserLoginDto;
import com.evoter.user.model.User;
import com.evoter.user.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class RouteController {
    private final UserService userService;

    public RouteController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Landing Page");
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Login");
        model.addAttribute("userLoginDetails", new UserLoginDto());
        return "login";
    }

//    @PostMapping("login")
//    public String login(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
//        User user = userService.getUserByUsernameAndPassword(username, password);
//        if (user != null) {
//            model.addAttribute("user", user);
//            return "redirect:/";
//        }
//        return "login";
//    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Register");
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Forgot Password");
        return "forgot-password";
    }

    @GetMapping("/dashboard/{userid}")
    public String dashboard(@PathVariable("userid") Long Id,  Model model) {
        User user = userService.getUserById(Id);
        model.addAttribute("pageTitle", "E-Voter - Dashboard");
        model.addAttribute("authUser", user);
        return "dashboard";
    }

    @GetMapping("/dashboard/profile")
    public String profile(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Profile");
        return "profile";
    }

    @GetMapping("/dashboard/polls")
    public String polls(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Polls");
        return "polls";
    }

    @GetMapping("/dashboard/add-poll")
    public String addPoll(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Add Poll");
        return "add_poll";
    }

    @GetMapping("/dashboard/vote")
    public String vote(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Vote");
        return "vote";
    }

    @GetMapping("/dashboard/add-admin")
    public String addAdmin(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Add Admin");
        return "add_admin";
    }

    @GetMapping("/dashboard/add-candidate")
    public String addCandidate(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Add Candidate");
        return "add_candidate";
    }

    @GetMapping("/dashboard/add-poll-type")
    public String addPollType(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Add Poll Type");
        return "add_poll_type";
    }

//    @GetMapping("/error")
//    public String error(Model model) {
//        model.addAttribute("pageTitle", "E-Voter - Error");
//        return "error";
//    }
}
