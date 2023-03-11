package com.evoter;

import com.evoter.user.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class RouteController {

    @GetMapping("/login-page")
    public String login(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Login");
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

    @GetMapping("/register-page")
    public String register(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Register");
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/forgot-password-page")
    public String forgotPassword(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Forgot Password");
        return "forgot-password";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Dashboard");
        return "dashboard";
    }

    @GetMapping("/dashboard/profile-page")
    public String profile(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Profile");
        return "profile";
    }

    @GetMapping("/dashboard/polls-page")
    public String polls(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Polls");
        return "polls";
    }

    @GetMapping("/dashboard/add-poll-page")
    public String addPoll(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Add Poll");
        return "add_poll";
    }

    @GetMapping("/dashboard/vote-page")
    public String vote(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Vote");
        return "vote";
    }

    @GetMapping("/dashboard/add-admin-page")
    public String addAdmin(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Add Admin");
        return "add_admin";
    }

    @GetMapping("/dashboard/add-candidate-page")
    public String addCandidate(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Add Candidate");
        return "add_candidate";
    }

    @GetMapping("/dashboard/add-poll-type-page")
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
