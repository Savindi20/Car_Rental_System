package com.easy.car_rental.config;

import com.easy.car_rental.advisor.AppWideExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// Spring container එකට spring beans(POJOs) dana class ekk.(Bean definition වලට source එකක්)
@EnableWebMvc
//Web mvc application ekk enable rnn bawitha krnw
@ComponentScan(basePackageClasses = {AppWideExceptionHandler.class}, basePackages = "com.easy.car_rental.controller")
//Beans scan කරන්න ඕන path එක (basePackages, basePackageClasses)
public class WebAppConfig implements WebMvcConfigurer {

    @Bean
    //අපේ නොවන class එකකින් spring bean හදන්න
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(500000000);
        return multipartResolver;
    }

    @Override
    //Supper class ekaka method ekk gnn
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**").addResourceLocations("/uploads/");
    }
}