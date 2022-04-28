package com.example.demotrade.service;

import java.util.List;
import java.util.Optional;

import com.example.demotrade.model.CountryParty;

/**
 * @author iqbalhussain
 *
 */
public interface CountryPartyService {

	/**
	 * @return list of countryparties
	 */
	List<CountryParty> findAll(String title);
	
	/**
	 * 
	 * @param id
	 * @return book 
	 */
	Optional<CountryParty> findById(Long id);
	
	/**
	 * 
	 * @param book
	 * @return book
	 */
	CountryParty save(CountryParty book);
	
	void deleteById(Long id);
	
}
