package com.karan.Insurance.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Claim {
	
	@Id
	@GeneratedValue
	private Integer claim_number;
	private String description;
	private String claim_data;
	private String claim_status;	// false or true
	
	@OneToOne(mappedBy = "claim")
	private InsurancePolicy policies;
	
	public Claim(Integer claim_number, String description, String claim_data, String claim_status) {
		super();
		this.claim_number = claim_number;
		this.description = description;
		this.claim_data = claim_data;
		this.claim_status = claim_status;
	}

	public Claim() {
		super();
	}

	public Integer getClaim_number() {
		return claim_number;
	}

	public void setClaim_number(Integer claim_number) {
		this.claim_number = claim_number;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getClaim_data() {
		return claim_data;
	}

	public void setClaim_data(String claim_data) {
		this.claim_data = claim_data;
	}

	public String getClaim_status() {
		return claim_status;
	}

	public void setClaim_status(String claim_status) {
		this.claim_status = claim_status;
	}
	

	public InsurancePolicy getPolicies() {
		return policies;
	}

	public void setPolicies(InsurancePolicy policies) {
		this.policies = policies;
	}

	@Override
	public String toString() {
		return "Claim [claim_number=" + claim_number + ", description=" + description + ", claim_data=" + claim_data
				+ ", claim_status=" + claim_status + "]";
	}

	
}
