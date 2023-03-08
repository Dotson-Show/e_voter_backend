package com.evoter;

import com.evoter.user.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RouteController {
    @GetMapping("")
    public String index(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Landing Page");
        return "index";
    }

    @GetMapping("login")
    public String login(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Login");
        return "login";
    }

    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Register");
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("forgot-password")
    public String forgotPassword(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Forgot Password");
        return "forgot-password";
    }

    @GetMapping("dashboard")
    public String dashboard(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Dashboard");
        return "dashboard";
    }

    @GetMapping("profile")
    public String profile(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Profile");
        return "profile";
    }

    @GetMapping("polls")
    public String polls(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Polls");
        return "polls";
    }

    @GetMapping("add-poll")
    public String addPoll(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Add Poll");
        return "add_poll";
    }

    @GetMapping("vote")
    public String vote(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Vote");
        return "vote";
    }

    @GetMapping("add-admin")
    public String addAdmin(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Add Admin");
        return "add_admin";
    }

    @GetMapping("add-candidate")
    public String addCandidate(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Add Candidate");
        return "add_candidate";
    }

    @GetMapping("add-poll-type")
    public String addPollType(Model model) {
        model.addAttribute("pageTitle", "E-Voter - Add Poll Type");
        return "add_poll_type";
    }
}
