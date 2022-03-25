package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@SpringBootApplication
@RestController
public class Main implements CommandLineRunner{

	@Autowired
    accountRepository kontoRepository;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}
	@GetMapping
	public String HelloWorld(){
		return "Hello World!";
	}
	@Override
	public void run(String... args) {
		kontoRepository.save(new account("HelloWorld"));
		List<account> konta = kontoRepository.findAll();
		konta.forEach(konto -> System.out.println(konto.show()));

        //konta.forEach(System.out::println);
		//System.out.println("Lista kont: " + konta.toString());
        //userRepository.save(someUser);

	}
	
}
