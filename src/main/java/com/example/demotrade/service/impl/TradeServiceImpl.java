/**
 * 
 */
package com.example.demotrade.service.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demotrade.model.Book;
import com.example.demotrade.model.CountryParty;
import com.example.demotrade.model.Trade;
import com.example.demotrade.repository.BookRepository;
import com.example.demotrade.repository.CountryPartyRepository;
import com.example.demotrade.repository.TradeRepository;
import com.example.demotrade.request.TradeRequestBody;
import com.example.demotrade.service.TradeService;

/**
 * @author iqbalhussain
 *
 */
@Service
@Transactional
public class TradeServiceImpl implements TradeService {

	@Autowired
	TradeRepository tradeRepository;
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	CountryPartyRepository countryPartyRepository;
	
	@Override
	public Trade saveTransmission(TradeRequestBody tradeRequestBody) throws Exception {
		//check maturity date, if greater then today then accept otherwise throw exeption
		if (null != tradeRequestBody.getMaturityDate()) {
			if (tradeRequestBody.getMaturityDate().after(new Date())) {
				throw new Exception(" Maturity date can't be lesser than today's date ");
			}
		}
		long v =001l;
		
		Book book = bookRepository.save(new Book(v,tradeRequestBody.getBookRequestBody().getTitle(), tradeRequestBody.getBookRequestBody().getDescription()));
		CountryParty countryParty = countryPartyRepository.save(new CountryParty(v, tradeRequestBody.getCountryPartyRequestBody().getName()));
		
		Trade trade = new Trade(v,
				  tradeRequestBody.getMaturityDate(),new Date(), 
				  tradeRequestBody.isExpired(), tradeRequestBody.getVersion());
		trade.setBookId(book);
		trade.setCountryId(countryParty);
		
		return tradeRepository.save(trade);
	}

	@Override
	public Optional<Trade> findById(long id) {
		return tradeRepository.findById(id);
	}

	@Override
	public Trade update(Trade incomingTrade, Optional<Trade> existingTradeData) throws Exception {
		//check exited trade version with the incoming request trade version, if lower version is received throw error else accept
		if (existingTradeData.isPresent()) {
			Trade _trade = existingTradeData.get();
			if(_trade.getVersion() < incomingTrade.getVersion()) {
				throw new Exception(" Lower version is not accepted");
			}
			else {
				_trade.setVersion(incomingTrade.getVersion());
				_trade.setBookId(incomingTrade.getBookId());
				_trade.setCountryId(incomingTrade.getCountryPartyId());
				_trade.setMaturityDate(incomingTrade.getMaturityDate());
				_trade.setExpired(incomingTrade.isExpired());
			}
			return tradeRepository.save(_trade);
		}
		
		return null;
	}

}
