package kr.hs.sdh.toast.repository;

import kr.hs.sdh.toast.entity.BankAccount;
import kr.hs.sdh.toast.entity.BankAccountHistory;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BankAccountRepository {
    @ConstructorArgs({
            @Arg(column = "ba_number", name = "number", id = true),
            @Arg(column = "ba_amount", name = "amount"),
            @Arg(column = "ba_alias", name = "alias"),
            @Arg(column = "ba_create_date", name = "createDateTime"),
            @Arg(column = "ba_maturity_date", name = "maturityDateTime"),
            @Arg(column = "ba_freeze", name = "isFreeze")
    })
    @Results(id = "bankAccount")
    @Select(value = "")
    BankAccount bankAccount();

    @Results(id = "bankAccountResults", value = {
            @Result(column = "ba_number", property = "number", id = true),
            @Result(column = "ba_amount", property = "amount"),
            @Result(column = "ba_alias", property = "alias"),
            @Result(column = "ba_create_date", property = "createDateTime"),
            @Result(column = "ba_maturity_date", property = "maturityDateTime"),
            @Result(column = "ba_freeze", property = "isFreeze"),
            @Result(column = "bb_uuid", property = "bankBook",one = @One(resultMap = BankBookRepository.BANK_BOOK)),
            @Result(column = "ba_number", property = "history",many = @Many(resultMap = BankAccountHistoryRepository.BANK_ACCOUNT_HISTORY))
    })
    @Select(value = "")
    BankAccount bankAccountResults();

    @ResultMap(value = "bankAccountResults")
    @Select(value = "select bank_account.*, bank_book.*, bank_account_history.* from bank_account join  people on bank_account.p_uuid = people.p_uuid join bank_book on bank_book.bb_uuid = bank_account.bb_uuid left join bank_account_history on bank_account.ba_number = bank_account_history.ba_number where people.p_identity = #{identity}")
    List<BankAccount> findAllbyIdentity(final String identity);

    @Select("select * from bank_account where ba_number = #{number}")
    BankAccount getAccountByNumber(String number);

    @Update("update bank_account set ba_amount = ba_amount - #{amount} where ba_number = #{number}")
    void updateAmountByNumber(String number, int amount);

}