package kr.hs.sdh.toast.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;


public class Client {
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String identity;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String name;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String email;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String contect;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String address;

    private List<Account> accounts;


    public Client(String identity, String name, String email, String contect, String address) {
        this.identity = identity;
        this.name = name;
        this.email = email;
        this.contect = contect;
        this.address = address;
    }

    public String getIdentity() {
        return identity;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getContect() {
        return contect;
    }

    public List<Account> getAccounts() {
        return accounts;
    }
    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
