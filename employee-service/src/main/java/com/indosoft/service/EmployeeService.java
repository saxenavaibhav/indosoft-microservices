package com.indosoft.service;

import com.indosoft.dto.ApiResponseDto;
import com.indosoft.dto.EmployeeDto;

public interface EmployeeService {

	public EmployeeDto saveEmployee(EmployeeDto employeeDto);
	
	public ApiResponseDto getEmployeeById(Long employeeId);
}
