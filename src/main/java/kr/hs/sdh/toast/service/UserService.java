package kr.hs.sdh.toast.service;

import kr.hs.sdh.toast.entity.Customer;
import kr.hs.sdh.toast.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Customer getCustomer(String id, String password) {
        System.out.println("sssssss " + userRepository.toString());
        Customer customer = this.userRepository.getCustomer(id, password);
        System.out.println("id:   " + id + " " + password);
        System.out.println(customer.getName());
        return customer;
    }
    public void setCustomer(Customer customer){
        this.userRepository.setCustomer(customer);
    }

    public Customer getCustomerById(String id) {
        Customer customer = this.userRepository.getCustomerById(id);
        return customer;
    }
}
