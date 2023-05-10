package com.indosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.indosoft.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization, Long>{
	
	public Organization findByOrganizationCode(String organizationCode);
}
