package com.integratec.model.repositories;

import com.integratec.model.domain.RequestPriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestPriorityRepository extends JpaRepository<RequestPriority, Long> {
}
