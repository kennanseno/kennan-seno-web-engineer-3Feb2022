package com.glints.task.controller;

import java.util.List;
import com.glints.task.dao.RestaurantRepository;
import com.glints.task.model.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/restaurant")
public class RestaurantController {

	@Autowired
	private RestaurantRepository restaurantRepository;


	@GetMapping
	public @ResponseBody List<Restaurant> getAllUsers() {
		return (List<Restaurant>) restaurantRepository.findAll();
	}
}
