package com.example.demotrade.request;

/**
 * @author iqbalhussain
 *
 */
public class CountryPartyRequestBody {

	private long id;
	private String name;
	

	public CountryPartyRequestBody() {}//DC
	
	public CountryPartyRequestBody(long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
	
}
