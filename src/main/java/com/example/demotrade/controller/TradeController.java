package com.example.demotrade.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demotrade.model.Trade;
import com.example.demotrade.request.TradeRequestBody;
import com.example.demotrade.service.TradeService;

/**
 * @author iqbalhussain
 *
 */
@RestController
@RequestMapping("/api")
public class TradeController {

	@Autowired
	TradeService tradeService;
	
	@PostMapping("/transmission")
	public ResponseEntity<Trade> saveTransmission(@RequestBody TradeRequestBody tradeRequestBody) {
		try {
			Trade tradeResponse = tradeService.saveTransmission(tradeRequestBody);
			return new ResponseEntity<>(tradeResponse, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/transmission/{id}")
	public ResponseEntity<Trade> updateBook(@PathVariable("id") long id, @RequestBody Trade incomingTrade) {
		try {
			Optional<Trade> existingTradeData = tradeService.findById(id);
			if (existingTradeData.isPresent()) {
				return new ResponseEntity<>(tradeService.update(incomingTrade, existingTradeData), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
