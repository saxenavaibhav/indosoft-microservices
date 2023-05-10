package com.indosoft.dto;

import java.time.LocalDateTime;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Schema(
		description = "Organization DTO model Information"
		)
public class OrganizationDto {
	
	Long id;
	
	@Schema(
			description = "Organization Name"
			)
	private String organizationName;

	@Schema(
			description = "Organization Description"
			)
	private String organizationDescription;
	
	@Schema(
			description = "Organization Code"
			)
	private String organizationCode;
	
	@Schema(
			description = "Organization Created Date"
			)
	private LocalDateTime createdDate;
}
