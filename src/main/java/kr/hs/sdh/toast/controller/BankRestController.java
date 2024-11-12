package kr.hs.sdh.toast.controller;

import jakarta.validation.Valid;
import kr.hs.sdh.toast.entity.Customer;
import kr.hs.sdh.toast.entity.Login;
import kr.hs.sdh.toast.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {
    private final UserService userService;
    public BankRestController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/login")
    public Customer login(@Valid Login login) {
        Customer customer = userService.getCustomer(login.getId(),login.getPassword());
//        Customer customer = userService.getCustomer(id,password);
        System.out.println(customer.getName());
        return customer;
    }

    @PostMapping("/signin")
    public String signin(@Valid Customer customer){
        try {
            userService.setCustomer(customer);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "[\"success.\"]";
    }
}
