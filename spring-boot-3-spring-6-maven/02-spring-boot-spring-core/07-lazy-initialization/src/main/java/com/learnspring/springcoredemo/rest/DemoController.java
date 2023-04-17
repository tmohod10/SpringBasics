package com.learnspring.springcoredemo.rest;

import com.learnspring.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    // define a private field for dependencies
    private Coach myCoach;

    // define constructor injection
    // qualifier name is same as class name except for the first char is lowercase
    @Autowired
    public DemoController(@Qualifier("cricketCoach")Coach theCoach) {
        System.out.println("In constructor: " + this.getClass().getSimpleName());
        myCoach = theCoach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
