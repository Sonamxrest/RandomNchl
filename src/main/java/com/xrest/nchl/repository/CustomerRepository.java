package com.xrest.nchl.repository;

import com.xrest.nchl.model.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends BaseRepository<Customer, Long> {
    @Query(value = "select c.first_name as first_name , c.last_name as last_name , c.balance, c.id as id from customer_banks cb " +
            " INNER join customer c on c.id = cb.customer_id where cb.banks_id = :bankId", nativeQuery = true)
    List<Customer> getAllCustomerByBankId(@Param("bankId") Long bankId);
}
