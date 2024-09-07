package com.guaranteeRateService.service;

import com.guaranteeRateService.dto.ApplicationDTO;
import com.guaranteeRateService.model.Application;

import java.util.Map;

public interface ApplicationService {
    public ApplicationDTO createApplication(Map<String,String> phoneNumber);
    public ApplicationDTO updateApplication(String applicationId, ApplicationDTO applicationDTO);
    public ApplicationDTO getApplication(String appIdOrPhoneNumber);
}
