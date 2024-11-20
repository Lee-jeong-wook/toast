package kr.hs.sdh.toast.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Account {
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String a_number;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private int a_amount;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private LocalDateTime a_reg_st_date;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private LocalDateTime a_reg_ed_date;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private boolean a_isActivate;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private UUID bk_uuid;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String identity;

    public Account(String a_number, int a_amount, LocalDateTime a_reg_st_date, LocalDateTime a_reg_ed_date, boolean a_isActivate, UUID bk_uuid, String identity) {
        this.a_number = a_number;
        this.a_amount = a_amount;
        this.a_reg_st_date = a_reg_st_date;
        this.a_reg_ed_date = a_reg_ed_date;
        this.a_isActivate = a_isActivate;
        this.bk_uuid = bk_uuid;
        this.identity = identity;
    }

    public @NotNull @NotEmpty(message = "가 입력되지 않았습니다.") String getA_number() {
        return a_number;
    }

    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    public int getA_amount() {
        return a_amount;
    }

    public @NotNull @NotEmpty(message = "가 입력되지 않았습니다.") LocalDateTime getA_reg_st_date() {
        return a_reg_st_date;
    }

    public @NotNull @NotEmpty(message = "가 입력되지 않았습니다.") LocalDateTime getA_reg_ed_date() {
        return a_reg_ed_date;
    }

    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    public boolean isA_isActivate() {
        return a_isActivate;
    }

    public @NotNull @NotEmpty(message = "가 입력되지 않았습니다.") UUID getBk_uuid() {
        return bk_uuid;
    }

    public @NotNull @NotEmpty(message = "가 입력되지 않았습니다.") String getIdentity() {
        return identity;
    }
}
