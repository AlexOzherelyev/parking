package dev.vorstu;

import dev.vorstu.service.InitializerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ParkingApplication {

	private static InitializerService initializerService;

	@Autowired
	public void setInitialLoader(InitializerService initializerService) {
		ParkingApplication.initializerService = initializerService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ParkingApplication.class, args);
		initializerService.initial();
	}

}
