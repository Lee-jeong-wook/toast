package kr.hs.sdh.toast.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Login {
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String id;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String password;
    public Login(String id, String password) {
        this.id = id;
        this.password = password;
    }
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }
}
