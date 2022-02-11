package com.glints.task.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ScheduleTest {
    
    @Test
    public void should_create_schedule_object() {
        Schedule schedule = new Schedule();
        assertNotNull(schedule);
    }

    @Test
    public void should_update_schedule_object_with_correct_day() {
        Schedule schedule = new Schedule();
        assertEquals(schedule.getMonday(), false);

        schedule.setSchedule("Mon");

        assertEquals(schedule.getMonday(), true);
    }

    @Test
    public void should_update_schedule_object_accordingly() {
        Schedule schedule = new Schedule();
        assertEquals(schedule.getMonday(), false);
        assertEquals(schedule.getTuesday(), false);
        assertEquals(schedule.getWednesday(), false);

        schedule.setSchedule("Mon", "Weds");

        assertEquals(schedule.getMonday(), true);
        assertEquals(schedule.getTuesday(), true);
        assertEquals(schedule.getWednesday(), true);
    }
}
