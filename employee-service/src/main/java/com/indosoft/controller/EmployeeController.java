package com.indosoft.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indosoft.dto.ApiResponseDto;
import com.indosoft.dto.EmployeeDto;
import com.indosoft.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/employee")
@AllArgsConstructor
@Tag(
		name= "Employee Service - Employee Controller",
		description = "Employee Controller exposed REST API for Employee Service"
	)
public class EmployeeController {

	private EmployeeService employeeService;
	
	@PostMapping
	@Operation(
			summary = "Save Employee REST API",
			description = "Save Employee REST API is is used to save Employee details to the DB"
			)
	@ApiResponse(
			responseCode = "201",
			description = "Http Status 201 Created"
			)
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto) {
		EmployeeDto savedEmployee = employeeService.saveEmployee(employeeDto);
		return new ResponseEntity<EmployeeDto>(savedEmployee, HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	@Operation(
			summary = "Get Employee REST API",
			description = "Get Employee REST API is is used to GET Employee from the DB"
			)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status 200 OK"
			)
	public ResponseEntity<ApiResponseDto> getEmployeeById(@PathVariable("id") Long employeeId) {
		ApiResponseDto apiResponseDto = employeeService.getEmployeeById(employeeId);
		return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
	}
}
