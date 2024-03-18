package com.assignment.schedule;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MyScheduler {
	
	private static Logger logger = LoggerFactory.getLogger(MyScheduler.class);

    @Scheduled(fixedRate = 2000)
    public void runTask() {
        System.out.println("Running scheduled task...");
        logger.info("schedular working");
    }
}
