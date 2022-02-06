package com.glints.task.controller;

import java.util.List;
import java.util.Optional;

import com.glints.task.dao.RestaurantRepository;
import com.glints.task.model.Restaurant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestaurantController {

	@Autowired
	private RestaurantRepository restaurantRepository;

	@GetMapping(path="/restaurant")
	public @ResponseBody List<Restaurant> getAllRestaurants() {
		return (List<Restaurant>) restaurantRepository.findAll();
	}

	@GetMapping(path="/restaurant/{id}")
	public @ResponseBody Restaurant getAll(@PathVariable Integer id) {
		Optional<Restaurant> optinalEntity =  restaurantRepository.findById(id);
		Restaurant restaurant = optinalEntity.get();
		return restaurant;
	}

	@GetMapping(path="/restaurant/search")
	public @ResponseBody Restaurant getRestaurant(@RequestParam String name) {
		return restaurantRepository.findByName(name);
	}
}
