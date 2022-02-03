package com.glints.task.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Restaurant {
    
    @Id
    private Integer id;

    private String name;

    @OneToMany(mappedBy="restaurant")
    private List<Schedule> schedules = new ArrayList<Schedule>();

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Schedule> getSchedules() {
        return schedules;
    }
}
