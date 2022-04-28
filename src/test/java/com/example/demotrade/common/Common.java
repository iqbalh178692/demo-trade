package com.example.demotrade.common;

import java.util.Date;

import com.example.demotrade.request.BookRequestBody;
import com.example.demotrade.request.CountryPartyRequestBody;
import com.example.demotrade.request.TradeRequestBody;

/**
 * @author iqbalhussain
 *
 */
public class Common {

	public static TradeRequestBody getTradeRequestBody() {
		CountryPartyRequestBody countryPartyRequestBody = new CountryPartyRequestBody(001,"INDIA");
		BookRequestBody bookRequestBody = new BookRequestBody(001,"Half Girlfriend", "Chetan Bhagat new story");
		TradeRequestBody tradeRequestBody = new TradeRequestBody(1l, countryPartyRequestBody, bookRequestBody, new Date(), true, 1l);
		return tradeRequestBody;
	}
}
