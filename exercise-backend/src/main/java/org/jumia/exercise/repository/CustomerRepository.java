package org.jumia.exercise.repository;

import org.jumia.exercise.domain.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Customer data repository
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
