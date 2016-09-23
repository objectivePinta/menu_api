package com.objective.payntza.attractions;

import com.objective.payntza.attractions.model.Account;
import com.objective.payntza.attractions.model.Attraction;
import com.objective.payntza.attractions.repositories.AccountRepository;
import com.objective.payntza.attractions.repositories.AttractionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AttractionsApplication {

  public static void main(String[] args) {
    SpringApplication.run(AttractionsApplication.class, args);
  }

	private static final Logger log = LoggerFactory.getLogger(AttractionsApplication.class);

	@Bean
  public CommandLineRunner demo(AttractionRepository repository, AccountRepository accountRepository) {

  	return (args) -> {
  		
  		repository.save(Attraction.builder().address("address").description("description").durationOfVisit(30).img("img").name("name").build());
		repository.save(Attraction.builder().address("address1").description("description1").durationOfVisit(30).img("img").name("name").build());
		repository.save(Attraction.builder().address("address2").description("description2").durationOfVisit(30).img("img").name("name").build());
		repository.save(Attraction.builder().address("address3").description("description3").durationOfVisit(30).img("img").name("name").build());
		repository.save(Attraction.builder().address("address4").description("description4").durationOfVisit(30).img("img").name("name").build());

		repository.findAll().forEach(attraction -> log.info(attraction.toString()));
		accountRepository.save(Account.builder().username("a").password("a").build());
	};

  }
}
