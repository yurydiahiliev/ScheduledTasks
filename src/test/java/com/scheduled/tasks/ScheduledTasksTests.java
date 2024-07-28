package com.scheduled.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class ScheduledTasksTests {

    @SpyBean
    private ScheduledTasks scheduledTasks;

    @Test
    public void testFixedRateTask() {
        await().atMost(3, TimeUnit.SECONDS).untilAsserted(() -> {
            verify(scheduledTasks, times(1)).performTask();
        });
    }

    @Test
    public void testFixedDelayTask() {
        await().atMost(5, TimeUnit.SECONDS).untilAsserted(() -> {
            verify(scheduledTasks, times(1)).performDelayedTask();
        });
    }

    @Test
    public void testCronTask() {
        await().atMost(6, TimeUnit.SECONDS).untilAsserted(() -> {
            verify(scheduledTasks, times(1)).performTaskUsingCron();
        });
    }
}