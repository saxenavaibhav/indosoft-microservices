package com.indosoft.service;

import com.indosoft.dto.OrganizationDto;

public interface OrganizationService {

	OrganizationDto saveOrganization(OrganizationDto organizationDto);
	
	OrganizationDto getOrganizationByCode(String organizationCode);	
}
