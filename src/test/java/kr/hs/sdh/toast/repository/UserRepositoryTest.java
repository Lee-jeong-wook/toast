package kr.hs.sdh.toast.repository;

import kr.hs.sdh.toast.entity.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserRepositoryTest {
    @Autowired
    private UserRepository userRepository;

    @Test
    void getCustomerById() {
        final Customer customer = userRepository.getCustomerById("admin");

        Assertions.assertNotNull(customer, "사용자 정보 안들어옴");
        Assertions.assertEquals("1", customer.getAlias(), "111");
    }
}