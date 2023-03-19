package br.com.ciceroednilson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class MsCarScheduleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsCarScheduleApplication.class, args);
	}

}
