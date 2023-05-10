package com.indosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indosoft.controller.DepartmentMapper;
import com.indosoft.dto.DepartmentDto;
import com.indosoft.entity.Department;
import com.indosoft.repository.DepartmentReposirory;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentReposirory departmentRepository;
	
	@Override
	public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
		Department department = DepartmentMapper.mapToDepartment(departmentDto);
		Department savedDepartment = departmentRepository.save(department);
		
		DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);
		return savedDepartmentDto;
	}

	@Override
	public DepartmentDto getDepartmentByCode(String departmentCode) {
		Department department = departmentRepository.findByDepartmentCode(departmentCode);
		
		DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);
		return departmentDto;
	}

}
