package com.example.demotrade.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.example.demotrade.common.Common;
import com.example.demotrade.model.Trade;
import com.example.demotrade.repository.BookRepository;
import com.example.demotrade.repository.CountryPartyRepository;
import com.example.demotrade.repository.TradeRepository;
import com.example.demotrade.request.TradeRequestBody;
import com.example.demotrade.service.impl.TradeServiceImpl;

/**
 * @author iqbalhussain
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class TradeControllerTest {

	@Configuration
	static class Config {
		
		@Bean
		public TradeServiceImpl tradeServiceImpl() {
			return mock(TradeServiceImpl.class);
		}
		
		@Bean 
		public TradeRepository tradeRepository() {
			return mock(TradeRepository.class);
		}
		
		@Bean 
		public BookRepository bookRepository() {
			return mock(BookRepository.class);
		}
		
		@Bean 
		public CountryPartyRepository countryPartyRepository() {
			return mock(CountryPartyRepository.class);
		}
		
		@Bean 
		public TradeController tradeController() {
			return mock(TradeController.class);
		}
	}
	
	@Autowired
	TradeServiceImpl tradeServiceImpl;
	
	@Autowired
	TradeController tradeController;
	
	@Test
	public void testSaveTransmission() {
		try {
			//ARRANGE
			TradeRequestBody tradeRequestBody = Common.getTradeRequestBody();
			
			ResponseEntity<?> response = tradeController.saveTransmission(tradeRequestBody);
			
			when(tradeServiceImpl.saveTransmission(Mockito.any())).thenReturn(new Trade());
			
			
			assertEquals(HttpStatus.CREATED, response.getStatusCode());
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
