/**
 * 
 */
package com.example.demotrade.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demotrade.model.CountryParty;
import com.example.demotrade.repository.CountryPartyRepository;
import com.example.demotrade.service.CountryPartyService;

/**
 * @author iqbalhussain
 *
 */
@Service
public class CountryPartyServiceImpl implements CountryPartyService {

	@Autowired
	CountryPartyRepository countryPartyRepository;
	
	
	@Override
	public List<CountryParty> findAll(String name) {
		List<CountryParty> countryPartys = new ArrayList<CountryParty>();
		if (name == null)
			countryPartyRepository.findAll().forEach(countryPartys::add);
		else
			countryPartyRepository.findByNameContaining(name).forEach(countryPartys::add);
		return countryPartys;
	}

	@Override
	public Optional<CountryParty> findById(Long id) {
		return countryPartyRepository.findById(id);
	}

	@Override
	public CountryParty save(CountryParty country) {
		return countryPartyRepository.save(new CountryParty(country.getName()));
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		countryPartyRepository.deleteById(id);
	}

}
