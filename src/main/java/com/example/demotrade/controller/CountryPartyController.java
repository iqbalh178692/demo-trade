/**
 * 
 */
package com.example.demotrade.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demotrade.model.CountryParty;
import com.example.demotrade.service.CountryPartyService;

/**
 * @author iqbalhussain
 *
 */
@RestController
public class CountryPartyController {

	@Autowired
	CountryPartyService countryPartyService;
	
	@GetMapping("/countryPartys")
	public ResponseEntity<List<CountryParty>> getAllCountryParties(@RequestParam(required = false) String name) {
		try {
			List<CountryParty> countryPartys = new ArrayList<CountryParty>();
			countryPartys = countryPartyService.findAll(name);
			
			if (countryPartys.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(countryPartys, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/countryParty/{id}")
	public ResponseEntity<CountryParty> getCountryPartyById(@PathVariable("id") long id) {
		Optional<CountryParty> countryParty = countryPartyService.findById(id);
		if (countryParty.isPresent()) {
			return new ResponseEntity<>(countryParty.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/countryParty")
	public ResponseEntity<CountryParty> createCountryParty(@RequestBody CountryParty book) {
		try {
			CountryParty _countryParty = countryPartyService.save(book);
			return new ResponseEntity<>(_countryParty, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/countryParty/{id}")
	public ResponseEntity<CountryParty> updateCountryParty(@PathVariable("id") long id, @RequestBody CountryParty countryParty) {
		Optional<CountryParty> tutorialData = countryPartyService.findById(id);
		if (tutorialData.isPresent()) {
			CountryParty _countryParty = tutorialData.get();
			_countryParty.setName(countryParty.getName());
			return new ResponseEntity<>(countryPartyService.save(_countryParty), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/countryParty/{id}")
	public ResponseEntity<HttpStatus> deleteCountryParty(@PathVariable("id") long id) {
		try {
			countryPartyService.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
