package com.assetmanagement.desklite.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assetmanagement.desklite.login.models.EmployeeModel;

@Repository
public interface IEmployeeDao extends JpaRepository<EmployeeModel,Integer  > {
  EmployeeModel findByUsername(String username);
}
