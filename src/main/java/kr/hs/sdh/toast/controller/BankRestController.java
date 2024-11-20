package kr.hs.sdh.toast.controller;

import jakarta.validation.Valid;
import kr.hs.sdh.toast.entity.Customer;
import kr.hs.sdh.toast.entity.Login;
import kr.hs.sdh.toast.service.BankService;
import kr.hs.sdh.toast.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankRestController {
    private final UserService userService;
    private final BankService bankService;
    public BankRestController(UserService userService, BankService bankService) {
        this.userService = userService;
        this.bankService = bankService;
    }
    @PostMapping("/login")
    public Customer login(@Valid Login login) {
        Customer customer = userService.getCustomer(login.getId(),login.getPassword());
//        Customer customer = userService.getCustomer(id,password);
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

    @PostMapping("/remittance")
    public String remittance(@Valid @RequestParam("ba_number") String ba_number,@RequestParam("tar_number") String tar_number, @RequestParam("amount") int amount, @RequestParam("memo") String memo){
        try {
            System.out.println("number is " + tar_number);
            bankService.sendMoney(ba_number,tar_number,amount,memo);
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
        return "[\"success.\"]";
    }
}
