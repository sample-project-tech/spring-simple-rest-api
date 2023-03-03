package com.sampleproject.tech.controller;

import com.sampleproject.tech.model.Customer;
import com.sampleproject.tech.service.CustomerService;
import com.sampleproject.tech.utils.CustomException;
import com.sampleproject.tech.utils.ResponsBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author imamsolikhin.tech@gmail.com
 */
@RestController
@RequestMapping("${api.path-sample}/customer")
public class CustomerController {

  @Autowired
  private CustomerService service;

  @GetMapping(value = "/em/search")
  public HttpEntity<Object> listEm(@RequestParam(defaultValue = "", required = false) String prm) {
    try {
      return new HttpEntity<>(service.searchRepo(prm));
    } catch (Exception e) {
      throw new CustomException("data doesn't exist", HttpStatus.BAD_GATEWAY);
    }
  }

  @GetMapping(value = "/jpa/search")
  public HttpEntity<Object> listJpa(@RequestParam(defaultValue = "", required = false) String prm) {
    try {
      return new HttpEntity<>(service.searchRepo(prm));
    } catch (Exception e) {
      throw new CustomException("data doesn't exist", HttpStatus.BAD_GATEWAY);
    }
  }

  @GetMapping(value = "/data")
  public HttpEntity<Object> data(@RequestParam String code) {
    try {
      if (!service.checkData(code)) {
        throw new CustomException("data doesn't exist", HttpStatus.BAD_REQUEST);
      }
      Object model = service.data(code);
      return new HttpEntity<>(new ResponsBody(model));
    } catch (Exception e) {
      throw new CustomException("data doesn't exist", HttpStatus.BAD_GATEWAY);
    }
  }

  @PostMapping(value = "/save")
  public HttpEntity<Object> save(@RequestBody Customer model) {
    try {
      if (service.checkData(model.getCode())) {
        throw new CustomException("data is exist", HttpStatus.BAD_REQUEST);
      }
      return new HttpEntity<>(new ResponsBody(service.save(model), "Save data success"));
    } catch (Exception e) {
      throw new CustomException("data doesn't save", HttpStatus.BAD_GATEWAY);
    }
  }

  @PostMapping(value = "/update")
  public HttpEntity<Object> update(@RequestBody Customer model) {
    try {
      if (!service.checkData(model.getCode())) {
        throw new CustomException("data doesn't exist", HttpStatus.BAD_REQUEST);
      }
      return new HttpEntity<>(new ResponsBody(service.update(model), "Update data success"));
    } catch (Exception e) {
      throw new CustomException("data doesn't update", HttpStatus.BAD_GATEWAY);
    }
  }

  @DeleteMapping(value = "/delete/{code}")
  public HttpEntity<Object> delete(@PathVariable String code) {
    try {
      if (!service.checkData(code)) {
        throw new CustomException("data doesn't exist", HttpStatus.BAD_REQUEST);
      }
      service.delete(code);
      return new HttpEntity<>(new ResponsBody("Delete data success"));
    } catch (Exception e) {
      throw new CustomException("data doesn't deleted", HttpStatus.BAD_GATEWAY);
    }
  }
}
