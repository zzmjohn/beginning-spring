package com.wiley.beginningspring.ch13;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Service;

/**
 * Created by mertcaliskan
 * on 22/10/14.
 */
@Service
public class SchedulerBean {

    @Scheduled(fixedDelay = 3000)
    @Scheduled(cron="0 00 01 * * *")
    public void doStuff() {
        System.out.println("Hi there!");
    }
}
