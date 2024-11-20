package kr.hs.sdh.toast.controller;

import kr.hs.sdh.toast.model.CustomerDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/signin")
    public String signin() {
        return "signin";
    }
    @GetMapping("/home")
    public String home() {
        return "home";
    }
    @GetMapping("/")
    public String main(@AuthenticationPrincipal CustomerDetails user, Model model) {
        model.addAttribute("user", user);
        return "index";
    }
}
