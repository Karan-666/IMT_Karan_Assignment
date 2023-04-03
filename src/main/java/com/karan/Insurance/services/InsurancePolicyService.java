package com.karan.Insurance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karan.Insurance.entity.Client;
import com.karan.Insurance.entity.InsurancePolicy;

@Service
public interface InsurancePolicyService {
	public List<InsurancePolicy> getAllInsurancePolicy();

	public Optional<InsurancePolicy> getOneInsurancePolicy(Integer id);

	public ResponseEntity<HttpStatus> addInsurancePolicy(InsurancePolicy insurancePolicy);

	public ResponseEntity<HttpStatus> updateInsurancePolicy(InsurancePolicy insurancePolicy);

	public ResponseEntity<HttpStatus> deleteInsurancePolicy(Integer id);
	
	public String getPolicyclaimData(Integer id); 
}
