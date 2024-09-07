package com.guaranteeRateService.Utility;

import java.util.UUID;

public class ApplicationIdGenerator {
    public static String generate(){
        String applicationId = "svc:grt:";
        applicationId = applicationId.concat(UUID.randomUUID().toString());
        return applicationId;
    }
}
