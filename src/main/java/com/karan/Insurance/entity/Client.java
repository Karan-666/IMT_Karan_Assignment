package com.karan.Insurance.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Client {
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String dob;
	private String address;

	@OneToMany(mappedBy = "client")
	private List<InsurancePolicy> policyList;

	public Client(Integer id, String name, String dob, String address) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.address = address;
	}

	public Client() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<InsurancePolicy> getPolicyList() {
		return policyList;
	}

	public void setPolicyList(List<InsurancePolicy> policyList) {
		this.policyList = policyList;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", dob=" + dob + ", address=" + address + "]";
	}

}
