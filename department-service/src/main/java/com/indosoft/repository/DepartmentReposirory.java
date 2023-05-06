package com.indosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.indosoft.entity.Department;

@Repository
public interface DepartmentReposirory extends JpaRepository<Department, Long>{

	Department findByDepartmentCode(String departmentCode);
}
