package kr.hs.sdh.toast.service;

import kr.hs.sdh.toast.entity.BankAccount;
import kr.hs.sdh.toast.entity.BankAccountHistory;
import kr.hs.sdh.toast.repository.BankAccountHistoryRepository;
import kr.hs.sdh.toast.repository.BankAccountRepository;
import kr.hs.sdh.toast.repository.BankBookRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BankService {
    private final BankAccountRepository bankAccountRepository;
    private final BankAccountHistoryRepository bankAccountHistoryRepository;
    private final BankBookRepository bankBookRepository;
    public BankService(BankAccountRepository bankAccountRepository, BankAccountHistoryRepository bankAccountHistoryRepository, BankBookRepository bankBookRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.bankAccountHistoryRepository = bankAccountHistoryRepository;
        this.bankBookRepository = bankBookRepository;
    }

    public void sendMoney(String ba_number,String tar_number, int amount, String memo){
        BankAccount bankAccount = this.bankAccountRepository.getAccountByNumber(tar_number);
        long money = bankAccount.getAmount();
        System.out.println(money);
        this.bankAccountRepository.updateAmountByNumber(tar_number, amount);
        BankAccountHistory bankAccountHistory = new BankAccountHistory(money, memo, bankAccount.getAmount(), 1, LocalDateTime.now());
        System.out.println("check money" + bankAccountHistory.getAmount());
        this.bankAccountHistoryRepository.setBankAccountHistory(bankAccountHistory, ba_number, tar_number);
    }
}
