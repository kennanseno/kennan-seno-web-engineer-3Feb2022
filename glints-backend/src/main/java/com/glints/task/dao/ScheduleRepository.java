package com.glints.task.dao;

import org.springframework.data.repository.CrudRepository;
import com.glints.task.model.Schedule;

public interface ScheduleRepository extends CrudRepository<Schedule, Integer> {

}