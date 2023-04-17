package com.learnspring.springcoredemo.common;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


// Primary qualifier will make this bean class as primary
// we can have only one primary annotation
// qualifier have higher priority than primary annotation
@Component
@Primary
public class TrackCoach implements Coach {
    @Override
    public String getDailyWorkout() {
        return "Run a hard 5K.";
    }
}
