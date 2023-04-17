package com.learnspring.springcoredemo.config;

import com.learnspring.springcoredemo.common.Coach;
import com.learnspring.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {

    // switchCoach1 or the method name here will be used as bean id
    // this name and the qualifier name should match
//    @Bean
//    public Coach swimCoach1() {
//        return new SwimCoach();
//    }

    // custom id to bean
    @Bean("aquatic")
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
