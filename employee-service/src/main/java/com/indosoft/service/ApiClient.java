package com.indosoft.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.indosoft.dto.DepartmentDto;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface ApiClient {

	@GetMapping("api/v1/department/{code}")
	public DepartmentDto getDepartmentByCode(@PathVariable("code") String code);
}
