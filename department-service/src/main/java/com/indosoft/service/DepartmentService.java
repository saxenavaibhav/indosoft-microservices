package com.indosoft.service;

import com.indosoft.dto.DepartmentDto;

public interface DepartmentService {

	DepartmentDto saveDepartment(DepartmentDto departmentDto);
	
	DepartmentDto getDepartmentByCode(String departmentCode);
}
