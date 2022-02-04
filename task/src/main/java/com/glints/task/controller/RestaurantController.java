package com.glints.task.controller;

import java.io.FileNotFoundException;
import java.util.List;
import com.glints.task.dao.RestaurantRepository;
import com.glints.task.dao.ScheduleRepository;
import com.glints.task.model.Restaurant;
import com.glints.task.util.DataTransformer;

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

	@Autowired
	private ScheduleRepository scheduleRepository;

	@GetMapping
	public @ResponseBody List<Restaurant> getAllRestaurants() {

		DataTransformer dataTransformer = new DataTransformer("src/main/resources/raw-data.csv");
		
		try {
			dataTransformer.transform(restaurantRepository, scheduleRepository);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return (List<Restaurant>) restaurantRepository.findAll();
	}
}
