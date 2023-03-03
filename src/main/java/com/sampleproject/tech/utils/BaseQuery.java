package com.sampleproject.tech.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.AliasToEntityMapResultTransformer;
import org.hibernate.transform.Transformers;

/**
 *
 * @author imamsolikhin.tech@gmail.com
 */
@MappedSuperclass
public abstract class BaseQuery extends Session {

  public String getMaxCode(String table, String where) {
    session = em.unwrap(org.hibernate.Session.class);
    String sql = "SELECT MAX(code) FROM " + table + " WHERE 1=1 " + where + " ORDER BY code DESC";
    NativeQuery q = session.createSQLQuery(sql);
    return (String) q.uniqueResult();
  }

  public <T> T uniqueResult(String sql, Class<T> dto) {
    session = em.unwrap(org.hibernate.Session.class);
    NativeQuery q = session.createSQLQuery(sql);
    q.setResultTransformer(Transformers.aliasToBean(dto));
    return (T) q.uniqueResult();
  }

  public Map<String, Object> singleResult(String sql) {
    session = em.unwrap(org.hibernate.Session.class);
    Map<String, Object> res = (Map<String, Object>) session.createNativeQuery(sql).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).getSingleResult();
    return res;
  }

  public List<Map<String, Object>> listResult(String sql) {
    session = em.unwrap(org.hibernate.Session.class);
    List<Map<String, Object>> res = session.createNativeQuery(sql).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
    return res;
  }

  public <T> List<T> listResult(String sql, Class<T> clazz) {
    session = em.unwrap(org.hibernate.Session.class);
    NativeQuery q = session.createSQLQuery(sql);
    q.setResultTransformer(Transformers.aliasToBean(clazz));
    return (List<T>) q.list();
  }

  public List<Map<String, Object>> listPagingResult(String sql, long page, long size) {
    session = em.unwrap(org.hibernate.Session.class);
    List<Map<String, Object>> res = session.createNativeQuery(sql + paging(page, size)).setResultTransformer(AliasToEntityMapResultTransformer.INSTANCE).list();
    return res;
  }

  public long countResult(String sql) {
    session = em.unwrap(org.hibernate.Session.class);
    return ((Number) session.createNativeQuery(sql).getSingleResult()).intValue();
  }

  public String toString(Object obj, String key) {
    HashMap<String, String> data = (HashMap<String, String>) obj;
    return data.get(key);
  }

  public String paging(long page, long size) {
    String limit = " LIMIT " + String.valueOf(fromPaging(page, size)) + "," + String.valueOf(toPaging(page, size));
    return limit;
  }

  public Long totalPage(long count, long size) {
    long total = count / size;
    return total + 1;
  }

  public Long fromPaging(long page, long size) {
    long from = page * size;
    return from;
  }

  public Long toPaging(long page, long size) {
    long to = size;
    return to;
  }

  public String getTableName(Class<?> clazz) {
    Class<?> c = clazz;
    Table table = c.getAnnotation(Table.class);
    return table.name();
  }

}
