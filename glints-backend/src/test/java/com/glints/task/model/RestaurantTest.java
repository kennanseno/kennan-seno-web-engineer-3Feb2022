package com.glints.task.model;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RestaurantTest {
    
    @Test
    public void should_create_restaurant_object() {
        Restaurant restaurant = new Restaurant("John Doe Restaurant");
        assertEquals(restaurant.getName(), "John Doe Restaurant");
    }
}
