package com.example.cinema.cinema;

import com.example.cinema.cinema.model.cinemaproperty.Director;
import com.example.cinema.cinema.repository.cinemaproperty.DirectorRepository;
import com.example.cinema.cinema.repository.cinemaproperty.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
		System.out.println("TEST");
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder){
		return builder.build();
	}

	@Bean
	public CommandLineRunner mappingDemo(DirectorRepository directorRepository, FilmRepository filmRepository) {
		return args -> {
			Director director = new Director("George", "Lucas");

			directorRepository.save(director);

//			filmRepository.save(new Film("Star Wars", director));
		};
	}

}
