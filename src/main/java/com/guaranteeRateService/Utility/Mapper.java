package com.guaranteeRateService.Utility;

import com.guaranteeRateService.dto.ApplicationDTO;
import com.guaranteeRateService.model.Application;

public class Mapper {
    public static ApplicationDTO modelToDTO(Application application){
        ApplicationDTO applicationDTO = new ApplicationDTO();
		applicationDTO.setApplicationId(application.getApplicationId());
		applicationDTO.setPhoneNumber(application.getPhoneNumber());
		applicationDTO.setEmail(application.getEmail());
		applicationDTO.setFirstName(application.getFirstName());
		applicationDTO.setMiddleName(application.getMiddleName());
		applicationDTO.setLastName(application.getLastName());
		applicationDTO.setRentOrOwn(application.getRentOrOwn());
		applicationDTO.setMonthlyHousePayment(application.getMonthlyHousePayment());
		applicationDTO.setEmploymentStatus(application.getEmploymentStatus());
		applicationDTO.setGrossAnnualIncome(application.getGrossAnnualIncome());
		applicationDTO.setIndustry(application.getIndustry());
		applicationDTO.setJobTitle(application.getJobTitle());
		applicationDTO.setEmployerName(application.getEmployerName());
		applicationDTO.setDateOfBirth(Util.stringDateFormat(application.getDateOfBirth()));
		applicationDTO.setSsnNumber(application.getSsnNumber());
		applicationDTO.setSoftPullConsent(application.getSoftPullConsent());
		applicationDTO.setCreatedAt(application.getCreatedAt());
		applicationDTO.setUpdatedAt(application.getUpdatedAt());
		if(application.getAddress()!=null){
			applicationDTO.setAddress(application.getAddress());
		}
		if(application.getProductRequest()!=null){
			applicationDTO.setProductRequest(application.getProductRequest());
		}
        return applicationDTO;
    }
    public static Application dtoToModel(ApplicationDTO applicationDTO){
        Application application = Application.builder()
        		.applicationId(applicationDTO.getApplicationId())
        		.phoneNumber(applicationDTO.getPhoneNumber())
        		.productRequest(applicationDTO.getProductRequest())
        		.email(applicationDTO.getEmail())
        		.firstName(applicationDTO.getFirstName())
        		.middleName(applicationDTO.getMiddleName())
        		.lastName(applicationDTO.getLastName())
        		.address(applicationDTO.getAddress())
        		.rentOrOwn(applicationDTO.getRentOrOwn())
        		.monthlyHousePayment(applicationDTO.getMonthlyHousePayment())
        		.employmentStatus(applicationDTO.getEmploymentStatus())
        		.grossAnnualIncome(applicationDTO.getGrossAnnualIncome())
        		.industry(applicationDTO.getIndustry())
        		.jobTitle(applicationDTO.getJobTitle())
        		.employerName(applicationDTO.getEmployerName())
        		.dateOfBirth(Util.localDateFormat(applicationDTO.getDateOfBirth()))
        		.ssnNumber(applicationDTO.getSsnNumber())
        		.softPullConsent(applicationDTO.getSoftPullConsent())
        		.build();
        return application;
    }
}
