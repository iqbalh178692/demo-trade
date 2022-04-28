package com.example.demotrade.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author iqbalhussain
 *
 */
@Entity
@Table(name = "trade")
public class Trade implements Serializable{

	private static final long serialVersionUID = -556683647021060095L;

	@Id
	@Column(name = "trade_id",updatable = false, nullable = false)
	private long tradeId;
	
	
	private CountryParty countryPartyId;
	
	
	private Book bookId;
	
	
	@Column(name="version")
	private Long version;
	
	
	@Column(name = "maturity_date")
	private Date maturityDate;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	@Column(name = "expired")
	private boolean expired;
	
	public Trade() {}
	
	

	public Trade(long tradeId, CountryParty countryPartyId, Long version, Book bookId, Date maturityDate,
			Date createdDate, boolean expired) {
		super();
		this.tradeId = tradeId;
		this.countryPartyId = countryPartyId;
		this.version = version;
		this.bookId = bookId;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expired = expired;
	}
	
	public Trade(long tradeId, Date maturityDate,
			Date createdDate, boolean expired, Long version) {
		this.tradeId = tradeId;
		this.version = version;
		this.maturityDate = maturityDate;
		this.createdDate = createdDate;
		this.expired = expired;
	}



	public long getTradeId() {
		return tradeId;
	}

	public void setTradeId(long tradeId) {
		this.tradeId = tradeId;
	}
	
	

	public CountryParty getCountryPartyId() {
		return countryPartyId;
	}



	public void setCountryPartyId(CountryParty countryPartyId) {
		this.countryPartyId = countryPartyId;
	}



	public Long getVersion() {
		return version;
	}



	public void setVersion(Long version) {
		this.version = version;
	}



	public CountryParty getCountryId() {
		return countryPartyId;
	}

	public void setCountryId(CountryParty countryPartyId) {
		this.countryPartyId = countryPartyId;
	}

	public Book getBookId() {
		return bookId;
	}

	public void setBookId(Book bookId) {
		this.bookId = bookId;
	}

	public Date getMaturityDate() {
		return maturityDate;
	}

	public void setMaturityDate(Date maturityDate) {
		this.maturityDate = maturityDate;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public boolean isExpired() {
		return expired;
	}

	public void setExpired(boolean expired) {
		this.expired = expired;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((countryPartyId == null) ? 0 : countryPartyId.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + (expired ? 1231 : 1237);
		result = prime * result + ((maturityDate == null) ? 0 : maturityDate.hashCode());
		result = prime * result + (int) (tradeId ^ (tradeId >>> 32));
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Trade other = (Trade) obj;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (countryPartyId == null) {
			if (other.countryPartyId != null)
				return false;
		} else if (!countryPartyId.equals(other.countryPartyId))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (expired != other.expired)
			return false;
		if (maturityDate == null) {
			if (other.maturityDate != null)
				return false;
		} else if (!maturityDate.equals(other.maturityDate))
			return false;
		if (tradeId != other.tradeId)
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

	
	
	
	
}
