package com.corona.tracker.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.corona.tracker.model.Locationstats;

public interface CoronaRepository extends JpaRepository<Locationstats, Integer>{
	
	//@Query("select state,country,latesttotalcases from Locationstats where country=?1")
	public List<Locationstats> findByCountry(String country);

}
