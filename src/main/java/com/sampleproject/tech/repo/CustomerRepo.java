package com.sampleproject.tech.repo;

import com.sampleproject.tech.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author imamsolikhin.tech@gmail.com
 */
public interface CustomerRepo extends JpaRepository<Customer, String> {

  boolean existsByCode(String code);

  Customer findByCode(String code);

  @Transactional
  void deleteByCode(String code);
}
