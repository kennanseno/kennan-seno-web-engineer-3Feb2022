package com.glints.task.dao;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

import com.glints.task.model.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

    Restaurant findByNameIgnoreCase(String name);
    List<Restaurant> getAllBySchedulesOpeningTimeIgnoreCase(String openingTime);
}