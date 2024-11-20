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
        Customer customer = this.userRepository.getCustomer(id, password);
        return customer;
    }
    public void setCustomer(Customer customer){
        this.userRepository.setCustomer(customer);
    }

    public Customer getCustomerById(String id) {
        return this.userRepository.getCustomerById(id);
    }
}
