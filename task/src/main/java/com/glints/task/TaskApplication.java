package com.glints.task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TaskApplication {

	public static void main(String[] args) throws FileNotFoundException {
		SpringApplication.run(TaskApplication.class, args);

		List<List<String>> records = new ArrayList<>();
		try (Scanner scanner = new Scanner(new File("src/main/resources/raw-data.csv"))) {
			while (scanner.hasNextLine()) {
				// records.add(getRecordFromLine(scanner.nextLine()));
			}
		}

	}

	// private List<String> getRecordFromLine(String line) {
	// 	List<String> values = new ArrayList<String>();
	// 	try (Scanner rowScanner = new Scanner(line)) {
	// 		rowScanner.useDelimiter(COMMA_DELIMITER);
	// 		while (rowScanner.hasNext()) {
	// 			values.add(rowScanner.next());
	// 		}
	// 	}
	// 	return values;
	// }

}
