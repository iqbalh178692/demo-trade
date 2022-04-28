package com.example.demotrade.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author iqbalhussain
 *
 */
@Entity
@Table(name = "country")
public class CountryParty implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1172358259910156880L;

	@Id
	@Column(name = "country_id",updatable = false, nullable = false)
	private long countryId;
	
	@Column(name = "name")
	private String name;

	
	public CountryParty() {}
	
	public CountryParty(String name) {
		this.name = name;
	}
	
	public CountryParty(long countryId, String name) {
		super();
		this.countryId = countryId;
		this.name = name;
	}

	public long getcountryId() {
		return countryId;
	}

	public void setcountryId(long countryId) {
		this.countryId = countryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (countryId ^ (countryId >>> 32));
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
		CountryParty other = (CountryParty) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (countryId != other.countryId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Country [countryId=" + countryId + ", name=" + name + "]";
	}
	
	
	
}
