package com.example.employee.restfulapi.controller;

import com.example.employee.restfulapi.entity.Company;
import com.example.employee.restfulapi.repository.CompanyRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import java.util.*;
import org.springframework.http.HttpStatus;


@RestController
public class CompanyController {
  @Autowired
  private CompanyRepository companyRepository;

  @GetMapping(value = "/companies")
  public ResponseEntity getCompanies() throws Exception {

    List<Company> companyList = companyRepository.findAll();

    return new ResponseEntity<>(companyList, HttpStatus.OK);
  }

  @GetMapping(value = "/companies/{id}")
  public ResponseEntity getCompanyById(@PathVariable Long id) throws Exception {

    Company company = companyRepository.findOne(id);

    return new ResponseEntity<>(company, HttpStatus.OK);
  }
}
