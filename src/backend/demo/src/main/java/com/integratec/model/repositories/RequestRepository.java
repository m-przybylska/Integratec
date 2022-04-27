package com.integratec.model.repositories;

import com.integratec.model.domain.Account;
import com.integratec.model.domain.Request;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long>, JpaSpecificationExecutor<Request> {

    @Query(value = "SELECT * FROM request r WHERE r.title LIKE %?1% OR r.text LIKE %?1% OR r.requestStatus LIKE %?1% OR r.requestCategory LIKE %?1% OR r.requestPriority LIKE %?1%",
            nativeQuery = true)
    public List<Request> findAll(String keyword);
}