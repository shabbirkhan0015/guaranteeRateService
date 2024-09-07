package com.guaranteeRateService.Utility;

import com.guaranteeRateService.dto.ApplicationDTO;
import com.guaranteeRateService.model.Application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mapper {
    public static ApplicationDTO modelToDTO(Application application){
        ApplicationDTO applicationDTO = ApplicationDTO.builder()
        		.applicationId(application.getApplicationId())
        		.phoneNumber(application.getPhoneNumber())
        		.productRequest(application.getProductRequest())
        		.email(application.getEmail())
        		.firstName(application.getFirstName())
        		.middleName(application.getMiddleName())
        		.lastName(application.getLastName())
        		.address(application.getAddress())
        		.rentOrOwn(application.getRentOrOwn())
        		.monthlyHousePayment(application.getMonthlyHousePayment())
        		.employmentStatus(application.getEmploymentStatus())
        		.grossAnnualIncome(application.getGrossAnnualIncome())
        		.industry(application.getIndustry())
        		.jobTitle(application.getJobTitle())
        		.employerName(application.getEmployerName())
        		.dateOfBirth(Util.stringDateFormat(application.getDateOfBirth()))
        		.ssnNumber(application.getSsnNumber())
        		.softPullConsent(application.getSoftPullConsent())
                .createdAt(application.getCreatedAt())
                .updatedAt(application.getUpdatedAt())
        		.build();
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
