/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sampleproject.tech.utils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 *
 * @author imamsolikhin.tech@gmail.com
 */
@Component
@Service
public class Session {

  @PersistenceContext
  public EntityManager em;

  public String FAILED = "FAILED";
  public String SUCCESS = "SUCCESS";

  public String INSERT = "INSERT";
  public String UPDATE = "UPDATE";
  public String DELETE = "DELETE";

  public Query query;
  public org.hibernate.Session session;
  public Transaction transaction;

}
