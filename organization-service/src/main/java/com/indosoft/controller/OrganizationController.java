package com.indosoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.indosoft.dto.OrganizationDto;
import com.indosoft.service.OrganizationService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("api/v1/organization")
@AllArgsConstructor
@Tag(
		name= "Organization Service - Organization Controller",
		description = "Organization Controller exposed REST API for Organization Service"
	)
public class OrganizationController {

	@Autowired
	private OrganizationService organizationService;
	
	@PostMapping
	@Operation(
			summary = "Save Organization REST API",
			description = "Save Organization REST API is is used to save Organization details to the DB"
			)
	@ApiResponse(
			responseCode = "201",
			description = "Http Status 201 Created"
			)
	public ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto) {
		return new ResponseEntity<>(organizationService.saveOrganization(organizationDto), HttpStatus.OK);
	}
	
	@GetMapping("{code}")
	@Operation(
			summary = "Get Organization REST API",
			description = "Get Organization REST API is is used to GET Organization from the DB"
			)
	@ApiResponse(
			responseCode = "200",
			description = "Http Status 200 OK"
			)
	public ResponseEntity<OrganizationDto> findByOrganizationCode(@PathVariable("code") String organizationCode) {
		return new ResponseEntity<>(organizationService.getOrganizationByCode(organizationCode), HttpStatus.OK);
	}
}
