package com.springframework.spring6di.services.i18n;

import com.springframework.spring6di.services.EnvironmentService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile("qa")
@Service
public class EnvironmentServiceQA implements EnvironmentService {

    @Override
    public String getEnv() {
        return "qa";
    }
}