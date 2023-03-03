/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sampleproject.tech.dao;

import com.sampleproject.tech.utils.BaseQuery;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Repository;

/**
 *
 * @author imamsolikhin.tech@gmail.com
 */
@Repository
public class CustomerDao extends BaseQuery {

  public Object data(String code) {
    try {
      String qry = " SELECT model.* FROM mst_customer model WHERE model.code = '" + code + "' ";
      return singleResult(qry);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }

  public List<Map<String, Object>> search(String prm) {
    try {
      String qry = " "
              + "SELECT model.* FROM mst_customer model WHERE model.code LIKE '%" + prm + "%' OR  model.name LIKE '%" + prm + "%' ";
      return listResult(qry);
    } catch (Exception e) {
      e.printStackTrace();
      return null;
    }
  }
}
