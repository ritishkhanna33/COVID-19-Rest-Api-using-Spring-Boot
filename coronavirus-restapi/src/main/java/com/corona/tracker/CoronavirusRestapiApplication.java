package com.corona.tracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.corona.tracker.service.CoronaVirusDataService;

@SpringBootApplication
public class CoronavirusRestapiApplication implements CommandLineRunner{

	@Autowired
	CoronaVirusDataService cvds;
	
	public static void main(String[] args) {
		SpringApplication.run(CoronavirusRestapiApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//cvds.fetchVirusData();
	}

}
