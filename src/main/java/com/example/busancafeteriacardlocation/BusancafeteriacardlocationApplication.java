package com.example.busancafeteriacardlocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.example.busancafeteriacardlocation.domain.map.service.InitService;

@SpringBootApplication
public class BusancafeteriacardlocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(BusancafeteriacardlocationApplication.class, args);
	}

	// 서버가 시작할때 api에 요청하는 코드

	@Component
	public static class DataInitializer implements CommandLineRunner {
	
		@Autowired
		private InitService initService;

		@Override
		public void run(String... args) throws Exception {
			initService.saveLocations();
		}
		
	}

}
