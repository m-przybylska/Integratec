package com.integratec.model.repositories;

import com.integratec.model.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>, JpaSpecificationExecutor<Account> {

    /*@Query(value = "SELECT * FROM account a WHERE a.login LIKE %?1% OR a.password LIKE %?1%",
            nativeQuery = true)
    public List<Account> findAll(String keyword);*/
}
