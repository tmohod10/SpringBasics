package com.learnspring.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructor: " + this.getClass().getSimpleName());
    }

    // define our init method
    // any method name works
    @PostConstruct
    public void doMyStartup() {
        System.out.println("In doMyStartup method: " + this.getClass().getSimpleName());
    }

    // define our destroy method
    @PreDestroy
    public void doMyCleanup() {
        System.out.println("In doMyCleanup method: " + this.getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes.";
    }
}
