package com.assetmanagement.desklite.login.dto;

import java.util.Set;

import com.assetmanagement.desklite.login.models.EmployeeModel;
import com.assetmanagement.desklite.login.models.RoleModel;

import lombok.Getter;

@Getter
public class EmployeeDto {
	private String username;
	private String password;
	private String workmail;
	private String workdept;
	private int companyId;
	private Set<RoleModel> roles;

	public EmployeeModel getUserFromDto() {
		System.out.println("Workmail " + new EmployeeDto().getWorkmail());
		EmployeeModel employeeModel = new EmployeeModel();

		employeeModel.setUsername(username);
		employeeModel.setPassword(password);
		employeeModel.setWorkmail(workmail);
		employeeModel.setWorkdept(workdept);

		System.out.println(employeeModel);
		return employeeModel;
	}
}
