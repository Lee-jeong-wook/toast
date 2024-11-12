package kr.hs.sdh.toast.Provider;

import org.springframework.security.authentication.dao.DaoAuthenticationProvider;

public class UserAuthenticationProvider extends DaoAuthenticationProvider {
    public UserAuthenticationProvider() {
        this.hideUserNotFoundExceptions = false;
    }
}
