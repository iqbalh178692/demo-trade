package com.example.demotrade.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demotrade.model.CountryParty;

/**
 * @author iqbalhussain
 *
 */
public interface CountryPartyRepository extends JpaRepository<CountryParty, Long> {
	List<CountryParty> findByNameContaining(String name);
}
