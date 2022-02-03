package com.glints.task.dao;

import org.springframework.data.repository.CrudRepository;
import com.glints.task.model.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {

}