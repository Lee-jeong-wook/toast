package kr.hs.sdh.toast.entity;

import java.time.LocalDateTime;

public class AccountLog {
    private String ba_number;
    private String ba_tar_number;
    private LocalDateTime bah_trans_date;
    private String bah_memo;
    private int amount;
    private boolean bah_type;
    private int before_money;

    public AccountLog(String ba_number, String ba_tar_number, LocalDateTime bah_trans_date, String bah_memo, int amount, boolean bah_type, int before_money) {
        this.ba_number = ba_number;
        this.ba_tar_number = ba_tar_number;
        this.bah_trans_date = bah_trans_date;
        this.bah_memo = bah_memo;
        this.amount = amount;
        this.bah_type = bah_type;
        this.before_money = before_money;
    }

    public String getBa_number() {
        return ba_number;
    }

    public String getBa_tar_number() {
        return ba_tar_number;
    }

    public LocalDateTime getBah_trans_date() {
        return bah_trans_date;
    }

    public String getBah_memo() {
        return bah_memo;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isBah_type() {
        return bah_type;
    }

    public int getBefore_money() {
        return before_money;
    }
}
