package com.rab3.dtos;

public class TeamDto {

	private Long id;
	private String name;
	private String country;
	private String mngr;
	private String logo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getMngr() {
		return mngr;
	}

	public void setMngr(String mngr) {
		this.mngr = mngr;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	@Override
	public String toString() {
		return "TeamDto [name=" + name + ", country=" + country + ", mngr=" + mngr + ", logo=" + logo + "]";
	}

}
