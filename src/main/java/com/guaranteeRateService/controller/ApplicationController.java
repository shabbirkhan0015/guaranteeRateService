package com.guaranteeRateService.controller;

import com.guaranteeRateService.dto.ApplicationDTO;
import com.guaranteeRateService.model.Application;
import com.guaranteeRateService.service.ApplicationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/app")
@RestController
public class ApplicationController {
    private ApplicationService applicationService;
    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }
    @PostMapping
    public ApplicationDTO createApplication(@RequestBody Map<String, String> phoneNumber){
        return applicationService.createApplication(phoneNumber);
    }
    @PutMapping("/{applicationId}")
    public ApplicationDTO updateApplication(@PathVariable String applicationId, @RequestBody ApplicationDTO applicationDTO){
        return applicationService.updateApplication(applicationId, applicationDTO);
    }
    @GetMapping("/{appIdOrPhoneNumber}")
    public ApplicationDTO getApplicationByAppIdOrPhoneNumber(@PathVariable String appIdOrPhoneNumber){
        return applicationService.getApplication(appIdOrPhoneNumber);
    }
}
