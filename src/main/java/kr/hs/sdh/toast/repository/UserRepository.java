package kr.hs.sdh.toast.repository;

import kr.hs.sdh.toast.entity.Customer;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Mapper
public interface UserRepository {
    String PEOPLE = "kr.hs.sdh.toast.repository.PeopleRepository.people";

    @Results(value = {
            @Result(column = "c_id", property = "id"),
            @Result(column = "c_password", property = "password"),
            @Result(column = "c_name", property = "name"),
            @Result(column = "c_identity", property = "identity"),
            @Result(column = "c_email", property = "email"),
            @Result(column = "c_contact", property = "contact"),
            @Result(column = "c_address", property = "address")
    })
    @Select("select * from customer where c_id = #{id} and c_password = #{pw}")
    public Customer getCustomer(String id, String pw);

    @Insert("insert into customer (c_id, c_password, c_name, c_identity, c_email, " +
            "c_contact, c_address)VALUES (#{id}, #{password}, #{name}, #{identity}, #{email}, #{contact}, #{address} )")
    public void setCustomer(Customer customer);

    @Results(id = "customer" ,value = {
            @Result(column = "c_id", property = "id"),
            @Result(column = "c_password", property = "password"),
            @Result(column = "c_alias", property = "alias"),
            @Result(column = "p_uuid", property = "people", one = @One(resultMap = PeopleRepository.PEOPLE)),
    })
    @Select("")
    Customer customer();

    @ResultMap("customer")
    @Select("select * from customer join people on customer.p_uuid = people.p_uuid   where c_id = #{id}")
    public Customer getCustomerById(String id);
}
