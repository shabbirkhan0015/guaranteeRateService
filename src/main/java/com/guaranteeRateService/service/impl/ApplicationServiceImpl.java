package com.guaranteeRateService.service.impl;

import com.guaranteeRateService.Utility.ApplicationIdGenerator;
import com.guaranteeRateService.Utility.Mapper;
import com.guaranteeRateService.Utility.Util;
import com.guaranteeRateService.dto.ApplicationDTO;
import com.guaranteeRateService.model.SecurityDetails;
import com.guaranteeRateService.exception.ErrorCode;
import com.guaranteeRateService.exception.GRException;
import com.guaranteeRateService.model.Application;
import com.guaranteeRateService.model.PersonalDetails;
import com.guaranteeRateService.repository.ApplicationRepository;
import com.guaranteeRateService.service.ApplicationService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@Service
public class ApplicationServiceImpl implements ApplicationService {
    private ApplicationRepository applicationRepository;
    public ApplicationServiceImpl(ApplicationRepository applicationRepository){
        this.applicationRepository = applicationRepository;
    }
    @Override
    public ApplicationDTO createApplication(Map<String, String> phoneNumber) {
        String applicationId = ApplicationIdGenerator.generate();
        Application application = new Application();
        application.setApplicationId(applicationId);
        Optional<String> number = Optional.ofNullable(phoneNumber.get("phoneNumber"));
        number.ifPresent(application::setPhoneNumber);
        return Mapper.modelToDTO(applicationRepository.save(application));
    }

    @Override
    public ApplicationDTO updateApplication(String applicationId, ApplicationDTO applicationDTO) {
        Application existingApplication = applicationRepository.findById(applicationId).orElseThrow(()-> new GRException(ErrorCode.APPLICATION_NOT_FOUND));
        existingApplication.setProductRequest(applicationDTO.getProductRequest());
        PersonalDetails personalDetails = getPersonalDetails(applicationDTO, existingApplication);
        SecurityDetails securityDetails = existingApplication.getSecurityDetails() == null ? new SecurityDetails(): existingApplication.getSecurityDetails();
        if(!Objects.equals(securityDetails, applicationDTO.getSecurityDetails())){
            securityDetails.setDateOfBirth(Util.localDateFormat(applicationDTO.getSecurityDetails().getDateOfBirth()));
            securityDetails.setSsnNumber(applicationDTO.getSecurityDetails().getSsnNumber());
        }
        existingApplication.setSecurityDetails(securityDetails);
        existingApplication.setPersonalDetails(personalDetails);
        existingApplication.setAddress(applicationDTO.getAddress());
        existingApplication.setSoftPullConsent(applicationDTO.getSoftPullConsent());
        return Mapper.modelToDTO(applicationRepository.save(existingApplication));
    }

    private PersonalDetails getPersonalDetails(ApplicationDTO applicationDTO, Application existingApplication) {
        PersonalDetails personalDetails = existingApplication.getPersonalDetails() == null ? new PersonalDetails() : existingApplication.getPersonalDetails();
        if(!Objects.equals(applicationDTO.getPersonalDetails(), personalDetails)){

            personalDetails.setEmail(applicationDTO.getPersonalDetails().getEmail());
            personalDetails.setFirstName(applicationDTO.getPersonalDetails().getFirstName());
            personalDetails.setMiddleName(applicationDTO.getPersonalDetails().getMiddleName());
            personalDetails.setLastName(applicationDTO.getPersonalDetails().getLastName());
            personalDetails.setRentOrOwn(applicationDTO.getPersonalDetails().getRentOrOwn());
            personalDetails.setMonthlyHousePayment(applicationDTO.getPersonalDetails().getMonthlyHousePayment());
            personalDetails.setEmploymentStatus(applicationDTO.getPersonalDetails().getEmploymentStatus());
            personalDetails.setGrossAnnualIncome(applicationDTO.getPersonalDetails().getGrossAnnualIncome());
            personalDetails.setIndustry(applicationDTO.getPersonalDetails().getIndustry());
            personalDetails.setJobTitle(applicationDTO.getPersonalDetails().getJobTitle());
            personalDetails.setEmployerName(applicationDTO.getPersonalDetails().getEmployerName());
        }
        return personalDetails;
    }

    public ApplicationDTO getApplication(String appIdOrPhoneNumber){
        if(appIdOrPhoneNumber.contains("svc:grt")){
            return Mapper.modelToDTO(applicationRepository.findById(appIdOrPhoneNumber).orElseThrow(()-> new GRException(ErrorCode.APPLICATION_NOT_FOUND)));
        }
        return Mapper.modelToDTO(applicationRepository.getByPhoneNumber(appIdOrPhoneNumber).stream().max(Comparator.comparing(Application::getCreatedAt)).orElseThrow(()-> new GRException(ErrorCode.APPLICATION_NOT_FOUND)));
    }


}
