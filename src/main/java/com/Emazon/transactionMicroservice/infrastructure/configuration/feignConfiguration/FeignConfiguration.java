package com.Emazon.transactionMicroservice.infrastructure.configuration.feignConfiguration;

import com.Emazon.transactionMicroservice.infrastructure.configuration.feignConfiguration.interceptor.JwtRequestInterceptor;
import feign.Client;
import feign.Logger;
import feign.httpclient.ApacheHttpClient;
import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {


    @Bean
    public Client feignClient() {
        return new ApacheHttpClient();
    }

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }


    @Bean
    public RequestInterceptor requestInterceptor(){
        return new JwtRequestInterceptor();
    }
}
