package com.guaranteeRateService.controller;

import com.guaranteeRateService.dto.ApplicationDTO;
import com.guaranteeRateService.model.Application;
import com.guaranteeRateService.model.SoftPullResponse;
import com.guaranteeRateService.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/softpull")
@RestController
public class SoftPullCheck {
    @Autowired
    private ApplicationRepository applicationRepository;

    @PostMapping("/{applicationId}")
    public ResponseEntity<SoftPullResponse> softPullCheckData(@PathVariable String applicationId) {
        Application application = applicationRepository.findById(applicationId).orElseThrow();
        SoftPullResponse softPullResponse = new SoftPullResponse();
        List<String> declineReasons = new ArrayList<>();

        // Validate age

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dateOfBirth = formatter.format(application.getSecurityDetails().getDateOfBirth());
        LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
        int age = Period.between(dob, LocalDate.now()).getYears();

        if (age < 18) {
            declineReasons.add("You are not meeting the minimum age requirement for this product.");
        }

        // Validate income
        Integer grossAnnualIncome = application.getPersonalDetails().getGrossAnnualIncome();

        if (grossAnnualIncome != null && grossAnnualIncome < 20000) {
            declineReasons.add("Your income is below the required $20,000 minimum.");
        }

        // Check for decline reasons
        if (!declineReasons.isEmpty()) {
            softPullResponse.setDeclineReasons(declineReasons);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(softPullResponse);
        }

        return ResponseEntity.ok(softPullResponse);
    }
}

