package com.kefelan.messaging.dbservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kefelan.messaging.dbservice.model.Quote;
import com.kefelan.messaging.dbservice.repository.QuotesRepository;

@RestController
@RequestMapping("/rest/db")
public class DbServiceResource {

	private QuotesRepository quotesRepository;

	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username){
		
		return quotesRepository.findByUserName(username)
		.stream()
		.map(Quote::getQuote).collect(Collectors.toList());
		
	}
	
	
	@PostMapping("/add")
	public List<String> add(@RequestBody final Quote quote){
		
		return null;
	}
}
