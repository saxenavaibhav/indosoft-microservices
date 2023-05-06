package com.indosoft.service;

import org.springframework.stereotype.Service;

import com.indosoft.dto.EmployeeDto;
import com.indosoft.entity.Employee;
import com.indosoft.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee(
			employeeDto.getId(),
			employeeDto.getFirstName(),
			employeeDto.getLastName(),
			employeeDto.getEmail()
		);
				
		Employee savedEmployee =  employeeRepository.save(employee);
		EmployeeDto savedEmployeeDto = new EmployeeDto(
				savedEmployee.getId(),
				savedEmployee.getFirstName(),
				savedEmployee.getLastName(),
				savedEmployee.getEmail()
			);
		return savedEmployeeDto;
	}

	@Override
	public EmployeeDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
		EmployeeDto employeeDto = new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail()
		);
		return employeeDto;
	}
}