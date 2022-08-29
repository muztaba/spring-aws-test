package com.seal.dockertest;

import com.seal.dockertest.entity.Book;
import com.seal.dockertest.entity.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DockerTestApplication {

	private final BookRepository bookRepository;

	public DockerTestApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(DockerTestApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			bookRepository.save(new Book("Java Concurrency in Practice"));
			bookRepository.save(new Book("Effective Java"));
		};
	}

}


