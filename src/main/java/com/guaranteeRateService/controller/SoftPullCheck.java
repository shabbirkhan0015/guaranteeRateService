package com.guaranteeRateService.controller;

import com.guaranteeRateService.dto.ApplicationDTO;
import com.guaranteeRateService.model.SoftPullResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RequestMapping("/softpull")
@RestController
public class SoftPullCheck {

    @GetMapping
    public ResponseEntity<SoftPullResponse> softPullCheckData(ApplicationDTO applicationData) {
        SoftPullResponse softPullResponse = new SoftPullResponse();
        List<String> declineReasons = new ArrayList<>();

        // Validate age
        String dateOfBirth = applicationData.getDateOfBirth();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate dob = LocalDate.parse(dateOfBirth, formatter);
        int age = Period.between(dob, LocalDate.now()).getYears();

        if (age < 18) {
            declineReasons.add("You are not meeting the minimum age requirement for this product.");
        }

        Integer grossAnnualIncome = applicationData.getGrossAnnualIncome(); // Assuming it's an Integer

        if (grossAnnualIncome != null && grossAnnualIncome < 20000) {
            declineReasons.add("Your income is below the required $20,000 minimum.");
        }

        // Check if any decline reasons were found
        if (!declineReasons.isEmpty()) {
            softPullResponse.setDeclineReasons(declineReasons);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(softPullResponse);
        }
        return ResponseEntity.ok().build();
    }
}
