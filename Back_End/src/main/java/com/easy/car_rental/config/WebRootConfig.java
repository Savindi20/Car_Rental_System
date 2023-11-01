package com.easy.car_rental.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
// Spring container එකට spring beans(POJOs) වැටෙන්න ඕන විදිය කියන class එකක්.
//(Bean definition වලට source එකක්)
@Import(JPAConfig.class)
//import one or more configuration classes into the current configuration class
@ComponentScan(basePackages = "com.easy.car_rental.service")
//Beans scan කරන්න ඕන path එක (basePackages, basePackageClasses)
public class WebRootConfig {

    @Bean
    //අපේ නොවන class එකකින් spring bean හදන්න
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}