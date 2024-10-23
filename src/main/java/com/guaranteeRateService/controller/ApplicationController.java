package com.guaranteeRateService.controller;

import com.guaranteeRateService.dto.ApplicationDTO;
import com.guaranteeRateService.model.Application;
import com.guaranteeRateService.service.ApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins = "*")
@RequestMapping("/app")
@RestController
@Slf4j
public class ApplicationController {
    private ApplicationService applicationService;
    public ApplicationController(ApplicationService applicationService){
        this.applicationService = applicationService;
    }
    @PostMapping
    public ApplicationDTO createApplication(@RequestBody Map<String, String> phoneNumber){
        ApplicationDTO response =  applicationService.createApplication(phoneNumber);
        log.info("APPLICATION CREATED: {}", response);
        return response;
    }
    @PutMapping("/{applicationId}")
    public ApplicationDTO updateApplication(@PathVariable String applicationId, @RequestBody ApplicationDTO applicationDTO){
        log.info("APPLICATION UPDATE Request Data: {}", applicationDTO);
        ApplicationDTO response=  applicationService.updateApplication(applicationId, applicationDTO);
        log.info("APPLICATION UPDATED Response Data: {}", response);
        return response;
    }
    @GetMapping("/{appIdOrPhoneNumber}")
    public ApplicationDTO getApplicationByAppIdOrPhoneNumber(@PathVariable String appIdOrPhoneNumber){
        return applicationService.getApplication(appIdOrPhoneNumber);
    }
}
