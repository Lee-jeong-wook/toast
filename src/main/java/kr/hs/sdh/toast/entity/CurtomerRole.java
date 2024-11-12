package kr.hs.sdh.toast.entity;

import jakarta.validation.constraints.NotNull;

public class CurtomerRole {
    @NotNull
    private String c_id;
    @NotNull
    private String r_id;

    public CurtomerRole(String c_id, String r_id) {
        this.c_id = c_id;
        this.r_id = r_id;
    }

    public String getC_id() {
        return c_id;
    }

    public String getR_id() {
        return r_id;
    }
}
