package com.karan.Insurance.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InsurancePolicy {

	@Id
	@GeneratedValue
	private Integer policy_number;
	private String policy_type;
	private long coverage_amount;
	private int premium;
	private String start_date;
	private String end_date;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	private Client client;
	
	//claim_claim_number // @JoinColumn for custom name of F.K.
	@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name= "fk_claim_id")
	private Claim claim;
	
	

	public InsurancePolicy(int policy_number, String policy_type, long coverage_amount, int premium, String start_date,
			String end_date) {
		super();
		this.policy_number = policy_number;
		this.policy_type = policy_type;
		this.coverage_amount = coverage_amount;
		this.premium = premium;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public InsurancePolicy() {
		super();
	}

	public Integer getPolicy_number() {
		return policy_number;
	}

	public void setPolicy_number(Integer policy_number) {
		this.policy_number = policy_number;
	}

	public String getPolicy_type() {
		return policy_type;
	}

	public void setPolicy_type(String policy_type) {
		this.policy_type = policy_type;
	}

	public long getCoverage_amount() {
		return coverage_amount;
	}

	public void setCoverage_amount(long coverage_amount) {
		this.coverage_amount = coverage_amount;
	}

	public int getPremium() {
		return premium;
	}

	public void setPremium(int premium) {
		this.premium = premium;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	

	public Claim getClaim() {
		return claim;
	}

	public void setClaim(Claim claim) {
		this.claim = claim;
	}

	@Override
	public String toString() {
		return "InsurancePolicy [policy_number=" + policy_number + ", policy_type=" + policy_type + ", coverage_amount="
				+ coverage_amount + ", premium=" + premium + ", start_date=" + start_date + ", end_date=" + end_date
				+ "]";
	}

}
