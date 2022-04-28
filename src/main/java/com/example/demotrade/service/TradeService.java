package com.example.demotrade.service;

import java.util.Optional;

import com.example.demotrade.model.Trade;
import com.example.demotrade.request.TradeRequestBody;

/**
 * @author iqbalhussain
 *
 */
public interface TradeService {

	/**
	 * Method is used to save the transmission request 
	 * @param tradeRequestBody
	 * @return Trade model
	 */
	Trade saveTransmission(TradeRequestBody tradeRequestBody) throws Exception;

	Optional<Trade> findById(long id);

	Trade update(Trade incomingTrade, Optional<Trade> existingTradeData) throws Exception ;

}
