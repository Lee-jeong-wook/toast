package kr.hs.sdh.toast.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Bankbook {
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private UUID uuid;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String name;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private BigDecimal intRate;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private boolean withdrawal;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private LocalDateTime regStDate;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private LocalDateTime regEdDate;
    @NotNull
    public Bankbook(String name, UUID uuid, BigDecimal intRate, boolean withdrawal, LocalDateTime regStDate, LocalDateTime regEdDate) {
        this.uuid = uuid;
        this.name = name;
        this.intRate = intRate;
        this.withdrawal = withdrawal;
        this.regStDate = regStDate;
        this.regEdDate = regEdDate;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getIntRate() {
        return intRate;
    }

    public LocalDateTime getRegEdDate() {
        return regEdDate;
    }

    public LocalDateTime getRegStDate() {
        return regStDate;
    }

    public UUID getUuid() {
        return uuid;
    }
}
