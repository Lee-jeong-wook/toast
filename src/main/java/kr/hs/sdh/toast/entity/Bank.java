package kr.hs.sdh.toast.entity;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.UUID;

public class Bank {
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private UUID uuid;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String name;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String rep;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String sector;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private String code;
    @NotNull
    @NotEmpty(message = "가 입력되지 않았습니다.")
    private LocalDateTime establishedDate;

    public Bank(UUID uuid, String name, String rep, String sector, String code, LocalDateTime establishedDate ) {
        this.uuid = uuid;
        this.name = name;
        this.rep = rep;
        this.sector = sector;
        this.code = code;
        this.establishedDate = establishedDate;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public LocalDateTime getEstablishedDate() {
        return establishedDate;
    }

    public String getRep() {
        return rep;
    }

    public String getSector() {
        return sector;
    }

    public UUID getUuid() {
        return uuid;
    }
}