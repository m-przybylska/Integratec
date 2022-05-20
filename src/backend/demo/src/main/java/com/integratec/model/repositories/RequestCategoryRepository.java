package com.integratec.model.repositories;

import com.integratec.model.domain.RequestCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestCategoryRepository extends JpaRepository<RequestCategory, Long> {
}
