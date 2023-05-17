package com.insurance.PolicyManagementMicroservice.config;

import brave.sampler.Sampler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PolicyConfig
{
    @Bean
    public Sampler sampler()
    {
        return Sampler.ALWAYS_SAMPLE;
    }
}
