/**
 * 
 */
package com.example.demotrade.request;

import java.util.Date;

/**
 * @author iqbalhussain
 *
 */
public class TradeRequestBody {
	private Long tradeId;
	private CountryPartyRequestBody countryPartyRequestBody;
	private BookRequestBody bookRequestBody;
	private Date maturityDate;
	private boolean expired;
	private Long version;
	
	public TradeRequestBody() {	}

	public TradeRequestBody(Long tradeId, CountryPartyRequestBody countryPartyRequestBody, BookRequestBody bookRequestBody,
			Date maturityDate, boolean expired, Long version) {
		super();
		this.tradeId = tradeId;
		this.countryPartyRequestBody = countryPartyRequestBody;
		this.bookRequestBody = bookRequestBody;
		this.maturityDate = maturityDate;
		this.expired = expired;
		this.version = version;
	}
	
	

	public Long getTradeId() {
		return tradeId;
	}

	public void setTradeId(Long tradeId) {
		this.tradeId = tradeId;
	}

	public CountryPartyRequestBody getCountryPartyRequestBody() {
		return countryPartyRequestBody;
	}

	public void setCountryPartyRequestBody(CountryPartyRequestBody countryPartyRequestBody) {
		this.countryPartyRequestBody = countryPartyRequestBody;
	}

	public BookRequestBody getBookRequestBody() {
		return bookRequestBody;
	}

	public void setBookRequestBody(BookRequestBody bookRequestBody) {
		this.bookRequestBody = bookRequestBody;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	
	
	
	
	
	
	
}
