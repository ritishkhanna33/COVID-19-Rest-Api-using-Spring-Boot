package com.corona.tracker.service;

import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corona.tracker.model.Locationstats;
import com.corona.tracker.repos.CoronaRepository;

@Service
public class CoronaVirusDataService {
	
	@Autowired
	CoronaRepository cr;
	
	private List<Locationstats> allStats= new ArrayList<>();
	
	public List<Locationstats> getAllStats() {
		return allStats;
	}

	private static String VIRUS_DATA_URL="https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_19-covid-Confirmed.csv";
	
	@PostConstruct
	public void fetchVirusData() throws IOException, InterruptedException {
		
		//List<LocationStats> newStat = new ArrayList<>();
		
		HttpClient client= HttpClient.newHttpClient();
		HttpRequest request= HttpRequest.newBuilder().uri(URI.create(VIRUS_DATA_URL)).build();
		
		HttpResponse<String> response= client.send(request, HttpResponse.BodyHandlers.ofString());
		
		StringReader csvBodyReader = new StringReader(response.body());
		Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(csvBodyReader);
		for (CSVRecord record : records) {
		    Locationstats locationStat= new Locationstats();
		    
		    locationStat.setState(record.get("Province/State"));
            locationStat.setCountry(record.get("Country/Region"));
            int latestCases = Integer.parseInt(record.get(record.size() - 1));
            locationStat.setLatestTotalCases(latestCases);
            
		    //newStat.add(locationStat);
            cr.save(locationStat);
		}
		
	}
}
