package kr.hs.sdh.toast.entity;

import jakarta.validation.constraints.NotNull;

public class Role {
    @NotNull
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String code;

    public Role(String id, String name, String code) {
        this.id = id;
        this.name = name;
        this.code = code;
    }

    public Role() {

    }

    public @NotNull String getId() {
        return id;
    }

    public @NotNull String getName() {
        return name;
    }

    public @NotNull String getCode() {
        return code;
    }
}
