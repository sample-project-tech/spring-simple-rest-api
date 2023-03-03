package com.sampleproject.tech.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

/**
 *
 * @author imamsolikhin.tech@gmail.com
 */
@Data
@Entity
@Table(name = "mst_customer")
public class Customer implements Serializable {

  @Id
  @Column(name = "code")
  private String code = "";

  @Column(name = "name")
  private String name = "";

  @Column(name = "email")
  private String email = "";

  @Column(name = "phone")
  private String phone = "";

  @Column(name = "address")
  private String address = "";
}
