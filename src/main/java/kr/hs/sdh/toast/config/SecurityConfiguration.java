package kr.hs.sdh.toast.config;

import kr.hs.sdh.toast.Provider.UserAuthenticationProvider;
import kr.hs.sdh.toast.entity.Customer;
import kr.hs.sdh.toast.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {

    private final UserService userService;

    public SecurityConfiguration(UserService userService) {
        this.userService = userService;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        return http
                .authenticationProvider(this.userAuthenticationProvider())
                .authorizeHttpRequests(registry ->
                        registry
                                .requestMatchers("/login").permitAll()
                                .requestMatchers("/signin").permitAll()
                                .requestMatchers("/fonts/**", "/images/**", "/styles/**", "/scripts/**").permitAll()
                                .anyRequest().authenticated()
                )
                .formLogin(
                        config -> config.loginPage("/login")
                                .loginProcessingUrl("/login-process")
                                .defaultSuccessUrl("/")
                                .usernameParameter("id")
                                .passwordParameter("password")
                                .failureHandler((request, response, exception) -> {
                                    exception.printStackTrace();
                                    response.sendRedirect("/login");
                                })
                )
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encode(rawPassword).equals(encodedPassword);
            }
        };
    }

    @Bean
    AuthenticationProvider userAuthenticationProvider() {
        UserAuthenticationProvider userAuthenticationProvider = new UserAuthenticationProvider();

        userAuthenticationProvider.setUserDetailsService(userId -> {
            final Customer customer = this.userService.getCustomerById(userId);
            System.out.println("customer: " + customer);
            if (customer == null) {
                String message = "%s 아이디를 가진 유저가 없습니다".formatted(userId);
                System.out.println(message);
                throw new UsernameNotFoundException(message);
            }
            return User.withUsername(customer.getId())
                    .password(customer.getPassword())
                    .build();
        });
        userAuthenticationProvider.setPasswordEncoder(this.passwordEncoder());
        return userAuthenticationProvider;
    }

    ;
}