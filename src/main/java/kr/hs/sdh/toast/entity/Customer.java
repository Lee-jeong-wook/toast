package kr.hs.sdh.toast.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class Customer {

    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String id;

    @NotNull()
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String password;

    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String name;

    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String identity;

    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String email;

    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String contact;

    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String address;

    public Customer(
        String id,
        String password,
        String name,
        String identity,
        String email,
        String contact,
        String address
    ) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.identity = identity;
        this.email = email;
        this.contact = contact;
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIdentity() {
        return identity;
    }

    public String getEmail() {
        return email;
    }

}