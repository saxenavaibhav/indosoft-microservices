package com.indosoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.indosoft.dto.OrganizationDto;
import com.indosoft.entity.Organization;
import com.indosoft.mapper.OrganizationMapper;
import com.indosoft.repository.OrganizationRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {

	@Autowired
	private OrganizationRepository organizationRepository;
	
	@Override
	public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
		Organization organization  = OrganizationMapper.mapToOrganization(organizationDto);
		Organization organizationSaved = organizationRepository.save(organization);
		return OrganizationMapper.mapToOrganizationDto(organizationSaved);
	}

	@Override
	public OrganizationDto getOrganizationByCode(String organizationCode) {
		Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
		return OrganizationMapper.mapToOrganizationDto(organization);
	}

}
