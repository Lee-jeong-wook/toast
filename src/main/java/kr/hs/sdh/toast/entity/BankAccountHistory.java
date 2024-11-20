package kr.hs.sdh.toast.entity;

import java.time.LocalDateTime;
import java.util.Set;

public class BankAccountHistory {
    private long amount;
    private String memo;
    private long beforeAmount;
    private int type;
    private LocalDateTime transDateTime;
    private Set<BankAccountHistory> bankAccountHistory;

    public BankAccountHistory(long amount, String memo, long beforeAmount, int type, LocalDateTime transDateTime) {
        this.amount = amount;
        this.memo = memo;
        this.beforeAmount = beforeAmount;
        this.type = type;
        this.transDateTime = transDateTime;
    }

    public long getAmount() {
        return amount;
    }

    public String getMemo() {
        return memo;
    }

    public long getBeforeAmount() {
        return beforeAmount;
    }

    public int getType() {
        return type;
    }

    public LocalDateTime getTransDateTime() {
        return transDateTime;
    }

    public void setBankAccountHistories(Set<BankAccountHistory> bankAccountHistories) {
        this.bankAccountHistory = bankAccountHistories;
    }
}
