package com.guaranteeRateService.Utility;

import com.guaranteeRateService.dto.ApplicationDTO;
import com.guaranteeRateService.dto.SecurityDetailsDTO;
import com.guaranteeRateService.model.Application;
import com.guaranteeRateService.model.SecurityDetails;

public class Mapper {
    public static ApplicationDTO modelToDTO(Application application){
        ApplicationDTO applicationDTO = new ApplicationDTO();
		applicationDTO.setApplicationId(application.getApplicationId());
		applicationDTO.setPhoneNumber(application.getPhoneNumber());
		applicationDTO.setSoftPullConsent(application.getSoftPullConsent());
		applicationDTO.setCreatedAt(application.getCreatedAt());
		applicationDTO.setUpdatedAt(application.getUpdatedAt());
		if(application.getAddress()!=null){
			applicationDTO.setAddress(application.getAddress());
		}
		if(application.getProductRequest()!=null){
			applicationDTO.setProductRequest(application.getProductRequest());
		}
        if(application.getPersonalDetails()!=null){
            applicationDTO.setPersonalDetails(application.getPersonalDetails());
        }
        if(application.getSecurityDetails()!=null){
            applicationDTO.setSecurityDetails(securityDetailsModelToDTO(application.getSecurityDetails()));
        }
        return applicationDTO;
    }
    public static Application dtoToModel(ApplicationDTO applicationDTO){
        Application application = Application.builder()
        		.applicationId(applicationDTO.getApplicationId())
        		.phoneNumber(applicationDTO.getPhoneNumber())
        		.productRequest(applicationDTO.getProductRequest())
        		.address(applicationDTO.getAddress())
                .personalDetails(applicationDTO.getPersonalDetails())
                .securityDetails(securityDetailsDTOToModel(applicationDTO.getSecurityDetails()))
        		.softPullConsent(applicationDTO.getSoftPullConsent())
        		.build();
        return application;
    }
    public static SecurityDetailsDTO securityDetailsModelToDTO(SecurityDetails securityDetails){
        SecurityDetailsDTO securityDetailsDTO = new SecurityDetailsDTO();
        securityDetailsDTO.setSsnNumber(securityDetails.getSsnNumber());
        securityDetailsDTO.setDateOfBirth(Util.stringDateFormat(securityDetails.getDateOfBirth()));
        return securityDetailsDTO;
    }
    public static SecurityDetails securityDetailsDTOToModel(SecurityDetailsDTO securityDetailsDTO){
        SecurityDetails securityDetails = new SecurityDetails();
        securityDetails.setSsnNumber(securityDetails.getSsnNumber());
        securityDetails.setDateOfBirth(Util.localDateFormat(securityDetailsDTO.getDateOfBirth()));
        return securityDetails;
    }
}
