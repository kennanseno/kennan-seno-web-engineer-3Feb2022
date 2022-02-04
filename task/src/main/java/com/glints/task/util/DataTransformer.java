package com.glints.task.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import com.glints.task.dao.RestaurantRepository;
import com.glints.task.dao.ScheduleRepository;
import com.glints.task.model.Restaurant;
import com.glints.task.model.Schedule;

public class DataTransformer {

    private String path;

    public DataTransformer(String path) {
        this.path = path;
    }

    /**
     *  Method to transform raw data(raw-data.csv) into information that can be consumed
     *  by the project and persisted in the database.
     * 
     * @param restaurantRepository
     * @param scheduleRepository
     */
    public void transform(RestaurantRepository restaurantRepository, ScheduleRepository scheduleRepository) {
        try (Scanner scanner = new Scanner(new File(path))) {
			while (scanner.hasNextLine()) {
	
				// Convert raw data to name & schedule(raw)
				List<String> restaurantInfo = getRecordFromLine(scanner.nextLine(), ",\"");
				Restaurant restaurant = new Restaurant(restaurantInfo.get(0).replace("\"", "").trim());

                // Save Restaurant object
                restaurantRepository.save(restaurant);

				// Transform to multiple schedule
				List<String> scheduleInfo = getRecordFromLine(restaurantInfo.get(1), "\\s?/\\s?");

				scheduleInfo.forEach(schedule -> {
                    Schedule scheduleObject = new Schedule();

                    //Get Closing time in schedule string
					String[] timeInfo  = schedule.split("\\s{1}-\\s{1}(?=\\d{1,2})");
					String closingTime = timeInfo[1].toUpperCase().replace("\"", "").trim();
                    scheduleObject.setClosingTime(closingTime);
					
					// Split to extract opening time
					timeInfo = timeInfo[0].split("\\s{1}(?=\\d{1,2})");
					String openingTime = timeInfo[1].toUpperCase().trim();
                    scheduleObject.setOpeningTime(openingTime);

                    String[] dayOfTheWeekArray = timeInfo[0].split("\\s?,\\s?");
                    List<String> dayOfTheWeekList = Arrays.asList(dayOfTheWeekArray);

                    dayOfTheWeekList.forEach(dayOfTheWeek -> {

                        // check if Mon - Sun pattern and update accordingly
                        if(dayOfTheWeek.matches(".*\\s?-\\s?.*")) {
                            String[] consecutiveDaysOfTheWeek = dayOfTheWeek.split("\\s?-\\s?");
                            scheduleObject.setSchedule(consecutiveDaysOfTheWeek[0], consecutiveDaysOfTheWeek[1]);
                        } else {
                            scheduleObject.setSchedule(dayOfTheWeek);
                        }
                    });

					scheduleObject.setRestaurant(restaurant);
                    scheduleRepository.save(scheduleObject);
				});
				
			}
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    public List<String> getRecordFromLine(String line, String delimiter) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(delimiter);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }   
}
