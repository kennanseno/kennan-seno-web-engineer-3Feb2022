package com.glints.task.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String openingTime;

    private String closingTime;

    private Boolean monday = false;

    private Boolean tuesday = false;

    private Boolean wednesday = false;

    private Boolean thursday = false;

    private Boolean friday = false;

    private Boolean saturday = false;

    private Boolean sunday = false;

    @ManyToOne
    @JoinColumn(name="restaurant_id", nullable=false)
    private Restaurant restaurant;

    public Schedule() { }

    public void setSchedule(String startingDay, String endDay) {
        List<String> dayOfTheWeek = List.of("MON", "TUES", "WEDS", "THURS", "FRI", "SAT", "SUN");
        startingDay = startingDay.toUpperCase();
        endDay = endDay.toUpperCase();

        // TODO: Need cleaner way to do this. Replace ASAP
        if(endDay.equals("THU")) {
            endDay = "THURS";
        }
        if(startingDay.equals("THU")) {
            startingDay = "THURS";
        }
        if(endDay.equals("WED")) {
            endDay = "WEDS";
        }
        if(startingDay.equals("WED")) {
            startingDay = "WEDS";
        }

        for(Integer startingDayIndex = dayOfTheWeek.indexOf(startingDay); startingDayIndex <= dayOfTheWeek.indexOf(endDay); startingDayIndex++) {
            setSchedule(dayOfTheWeek.get(startingDayIndex));
        }
    }

    public void setSchedule(String day) {
        String dayOfTheWeek = day.toUpperCase();
        switch(dayOfTheWeek) {
            case "MON":
                monday = true;
                break;
            case "TUES":
                tuesday = true;
                break;
            case "WEDS":
                wednesday = true;
                break;
            case "THURS":
                thursday = true;
                break;
            case "FRI":
                friday = true;
                break;
            case "SAT":
                saturday = true;
                break;
            case "SUN":
                sunday = true;
                break;
        }
    }

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

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public void setClosingTime(String closingTime) {
        this.closingTime = closingTime;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
