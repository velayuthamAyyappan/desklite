package com.assetmanagement.desklite.login.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.assetmanagement.desklite.login.dto.EmployeeDto;
import com.assetmanagement.desklite.login.models.EmployeeModel;


@Component
public interface IUserService {
	 EmployeeModel save(EmployeeDto employeeDto);
	    List<EmployeeModel> findAll();
	    EmployeeModel findOne(String username);
}
