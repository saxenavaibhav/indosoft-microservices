package com.indosoft.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indosoft.dto.DepartmentDto;
import com.indosoft.service.DepartmentService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/department")
@AllArgsConstructor
@Tag(
		name= "Department Service - Department Controller",
		description = "Department Controller exposed REST API for Department Service"
	)
public class DepartmentController {

	private DepartmentService departmentService;
	
	@Operation(
			summary = "Save Department REST API",
			description = "Save Department REST API is is used to save department details to the DB"
			)
	@ApiResponse(
			responseCode = "201",
			description = "Http Status 201 Created"
			)
	@PostMapping
	public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto) {
		DepartmentDto savedDepartment = departmentService.saveDepartment(departmentDto);
		return new ResponseEntity<>(savedDepartment, HttpStatus.CREATED);
	}
	
	@Operation(
			summary = "Get Department REST API",
			description = "Get Department REST API is is used to GET department from the DB"
			)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status 200 OK"
			)
	@GetMapping("{code}")
	public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("code") String code) {
		return new ResponseEntity<>(departmentService.getDepartmentByCode(code),
				HttpStatus.OK);
	}
}
