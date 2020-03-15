package com.corona.tracker.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corona.tracker.model.Locationstats;
import com.corona.tracker.repos.CoronaRepository;

@RestController
@RequestMapping("/coronastats")
public class CoronaController {

	@Autowired
	CoronaRepository cr;
	
	@GetMapping("/{country}")
	public List<Locationstats> getCoronaStatByCountry(@PathVariable String country) throws IOException, InterruptedException{
		return cr.findByCountry(country);
	}
	
	@GetMapping("/all")
	public List<Locationstats> getAllCoronaStatByCountry() throws IOException, InterruptedException{
		return cr.findAll();
	}
}
