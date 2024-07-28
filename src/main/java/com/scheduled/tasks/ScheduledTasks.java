package com.scheduled.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Scheduled(fixedRate = 2000) // This method will be executed every 2 seconds, regardless of the duration of the previous execution.
    public void performTask() {
        logger.info("Fixed Rate Task :: Execution Time - {}", LocalDateTime.now());
    }

    @Scheduled(fixedDelay = 4000) // This method will be executed 4 seconds after the previous execution has completed.
    public void performDelayedTask() {
        logger.info("Fixed Delay Task :: Execution Time - {}", LocalDateTime.now());
    }

    @Scheduled(cron = "*/5 * * * * *") // This method will be executed using a cron expression. In this case, it runs every 5 seconds.
    public void performTaskUsingCron() {
        logger.info("Cron Task :: Execution Time - {}", LocalDateTime.now());
    }
}
