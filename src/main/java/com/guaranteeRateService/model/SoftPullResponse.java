package com.guaranteeRateService.model;

import java.util.List;

public class SoftPullResponse {
    private List<String> declineReasons;

    // Getters and Setters
    public List<String> getDeclineReasons() {
        return declineReasons;
    }

    public void setDeclineReasons(List<String> declineReasons) {
        this.declineReasons = declineReasons;
    }
}
