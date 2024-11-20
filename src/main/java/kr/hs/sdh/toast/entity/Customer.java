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
    private String alias;

    private People people;

    public People getPeople() {
        return people;
    }

    public Customer(String id, String password, String alias) {
        this.id = id;
        this.password = password;
        this.alias = alias;
    }

    public @NotNull @NotEmpty(message = "가 입력되지 않았습니다.") String getId() {
        return id;
    }

    public @NotNull() @NotEmpty(message = "가 입력되지 않았습니다.") String getPassword() {
        return password;
    }

    public @NotNull @NotEmpty(message = "가 입력되지 않았습니다.") String getAlias() {
        return alias;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}