package com.glints.task.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Schedule {

    @Id
    private Integer id;

    private String openingTime;

    private String closingTime;

    private Boolean monday;

    private Boolean tuesday;

    private Boolean wednesday;

    private Boolean thursday;

    private Boolean friday;

    private Boolean saturday;

    private Boolean sunday;

    @ManyToOne
    @JoinColumn(name="restaurant_id", nullable=false)
    private Restaurant restaurant;

    public Integer getId() {
        return id;
    }

    public Boolean getMonday() {
        return monday;
    }

    public Boolean getTuesday() {
        return tuesday;
    }

    public Boolean getWednesday() {
        return wednesday;
    }

    public Boolean getThursday() {
        return thursday;
    }

    public Boolean getFriday() {
        return friday;
    }

    public Boolean getSaturday() {
        return saturday;
    }

    public Boolean getSunday() {
        return sunday;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public String getClosingTime() {
        return closingTime;
    }
}
