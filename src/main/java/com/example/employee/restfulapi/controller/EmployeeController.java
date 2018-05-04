package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.entity.Employee;
import com.example.employee.restfulapi.repository.CompanyRepository;
import com.example.employee.restfulapi.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.*;
import org.springframework.http.HttpStatus;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping(value = "/employees")
public class EmployeeController {

  @Autowired
  private EmployeeRepository employeeRepository;

  @GetMapping(value = "")
  public ResponseEntity getAllEmployees() throws Exception {
    List<Employee> employeeList = employeeRepository.findAll();

    return new ResponseEntity<>(employeeList, HttpStatus.OK);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity getCompanyById(@PathVariable Long id) throws Exception {

    Employee employee = employeeRepository.findOne(id);

    return new ResponseEntity<>(employee, HttpStatus.OK);
  }


}
