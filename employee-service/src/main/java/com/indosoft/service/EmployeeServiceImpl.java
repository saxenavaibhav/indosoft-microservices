package com.indosoft.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.indosoft.dto.ApiResponseDto;
import com.indosoft.dto.DepartmentDto;
import com.indosoft.dto.EmployeeDto;
import com.indosoft.dto.OrganizationDto;
import com.indosoft.entity.Employee;
import com.indosoft.mapper.EmployeeMapper;
import com.indosoft.repository.EmployeeRepository;

import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	private EmployeeRepository employeeRepository;
	
	//private RestTemplate restTemplate;
	
	private WebClient webClient;
	
	private ApiClient apiClient;
	
	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
				
		Employee savedEmployee =  employeeRepository.save(employee);
		EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(savedEmployee);
		return savedEmployeeDto;
	}

	@Override
	//@CircuitBreaker(name = "${spring.application.name}", fallbackMethod="getDefaultDepartment")
	@Retry(name = "${spring.application.name}", fallbackMethod="getDefaultDepartment")
	public ApiResponseDto getEmployeeById(Long employeeId) {
		
		LOGGER.info("Inside getEmployeeById");
		Employee employee = employeeRepository.findById(employeeId).get();
//		ResponseEntity<DepartmentDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/v1/department/" + employee.getDepartmentCode(),
//								  DepartmentDto.class);
//		DepartmentDto departmentDto = webClient.get().uri("http://localhost:8081/api/v1/employee/" + employee.getId())
//						.retrieve().bodyToMono(DepartmentDto.class).block();
		DepartmentDto departmentDto = apiClient.getDepartmentByCode(employee.getDepartmentCode());
		EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);
		
		OrganizationDto organizationDto = webClient.get().uri("http://localhost:8083/api/v1/organization/" + employee.getOrganizationCode())
				.retrieve().bodyToMono(OrganizationDto.class).block();
		
		ApiResponseDto apiResponseDto = new ApiResponseDto();
		apiResponseDto.setDepartment(departmentDto);
		apiResponseDto.setOrganization(organizationDto);
		apiResponseDto.setEmployee(employeeDto);
		return apiResponseDto;
	}
	
	public ApiResponseDto getDefaultDepartment(Long employeeId, Exception exception) {
		LOGGER.info("Inside getEmployeeById Fallback");
		Employee employee = employeeRepository.findById(employeeId).get();
		
		DepartmentDto departmentDto = new DepartmentDto();
		departmentDto.setDepartmentName("R & D Department");
		departmentDto.setDepartmentCode("RD001");
		departmentDto.setDepartmentDescription("Research & Development Department");
		
		
		EmployeeDto employeeDto = new EmployeeDto(
				employee.getId(),
				employee.getFirstName(),
				employee.getLastName(),
				employee.getEmail(),
				employee.getDepartmentCode(),
				employee.getOrganizationCode()
		);

		ApiResponseDto apiResponseDto = new ApiResponseDto();
		apiResponseDto.setDepartment(departmentDto);
		apiResponseDto.setEmployee(employeeDto);
		return apiResponseDto;
	}
}