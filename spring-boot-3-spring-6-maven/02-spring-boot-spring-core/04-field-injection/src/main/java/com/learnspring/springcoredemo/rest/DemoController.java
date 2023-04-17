package com.learnspring.springcoredemo.rest;

import com.learnspring.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for dependencies
    // this is field injection
    @Autowired
    private Coach myCoach;

    // define setter injection
    // no need to call the constructor or setter
    // this type of injection is not recommended by spring as
    // it is hard to unit test

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
