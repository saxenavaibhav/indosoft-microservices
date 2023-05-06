package com.indosoft.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.indosoft.dto.ApiResponseDto;
import com.indosoft.dto.DepartmentDto;
import com.indosoft.dto.EmployeeDto;
import com.indosoft.entity.Employee;
import com.indosoft.repository.EmployeeRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;
	
	//private RestTemplate restTemplate;
	
	//private WebClient webClient;
	
	private ApiClient apiClient;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = new Employee(
			employeeDto.getId(),
			employeeDto.getFirstName(),
			employeeDto.getLastName(),
			employeeDto.getEmail(),
			employeeDto.getDepartmentCode()
			
		);
				
		Employee savedEmployee =  employeeRepository.save(employee);
		EmployeeDto savedEmployeeDto = new EmployeeDto(
				savedEmployee.getId(),
				savedEmployee.getFirstName(),
				savedEmployee.getLastName(),
				savedEmployee.getEmail(),
				employeeDto.getDepartmentCode()
			);
		return savedEmployeeDto;
	}

	@Override
	public ApiResponseDto getEmployeeById(Long employeeId) {
		Employee employee = employeeRepository.findById(employeeId).get();
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/department/" + employee.getDepartmentCode(),
//								  DepartmentDto.class);
//		DepartmentDto departmentDto = webClient.get().uri("http://localhost:8080/api/v1/department/" + employee.getDepartmentCode())
//						.retrieve().bodyToMono(DepartmentDto.class).block();
		DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
		EmployeeDto employeeDto = new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartmentCode()
		);
		
		ApiResponseDto apiResponseDto = new ApiResponseDto();
		apiResponseDto.setDepartment(departmentDto);
		apiResponseDto.setEmployee(employeeDto);
		return apiResponseDto;
	}
}