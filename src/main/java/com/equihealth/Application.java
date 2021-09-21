package com.equihealth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.equihealth.core.api.PriceMeAPI;


@SpringBootApplication

@Import({PriceMeAPI.class})
public class Application extends SpringBootServletInitializer {


  @Bean
  public HandlerMapping handlerMapping() {
    return new RequestMappingHandlerMapping();
  }


  @Bean
  public HandlerAdapter handlerAdapter() {
    return new RequestMappingHandlerAdapter();
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }
}