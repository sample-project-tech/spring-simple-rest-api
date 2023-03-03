package com.sampleproject.tech.service;

import com.sampleproject.tech.dao.CustomerDao;
import com.sampleproject.tech.model.Customer;
import com.sampleproject.tech.repo.CustomerRepo;
import com.sampleproject.tech.utils.CustomException;
import com.sampleproject.tech.utils.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author imamsolikhin.tech@gmail.com
 */
@Service
public class CustomerService extends Session {

  @Autowired
  private CustomerRepo repo;
  @Autowired
  private CustomerDao dao;

  public boolean checkData(String code) {
    try {
      return repo.existsByCode(code);
    } catch (Exception e) {
      throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  public Object searchDao(String code) {
    try {
      return dao.search(code);
    } catch (Exception e) {
      throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  public Object searchRepo(String code) {
    try {
      return repo.findAll();
    } catch (Exception e) {
      throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  public Object data(String id) {
    try {
      return dao.data(id);
    } catch (Exception e) {
      throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @Transactional
  public Customer save(Customer model) {
    try {
      return repo.save(model);
    } catch (Exception e) {
      throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @Transactional
  public Customer update(Customer model) {
    try {
      return repo.save(model);
    } catch (Exception e) {
      throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @Transactional
  public void delete(String code) {
    try {
      repo.deleteByCode(code);
    } catch (Exception e) {
      throw new CustomException(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }
}
