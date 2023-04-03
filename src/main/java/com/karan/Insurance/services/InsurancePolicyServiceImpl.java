package com.karan.Insurance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karan.Insurance.entity.InsurancePolicy;
import com.karan.Insurance.entity.InsurancePolicy;
import com.karan.Insurance.exception.InsurancePolicyNotFoundException;
import com.karan.Insurance.repository.InsurancePolicyRepository;
import com.karan.Insurance.repository.InsurancePolicyRepository;

@Service
public class InsurancePolicyServiceImpl implements InsurancePolicyService {
	
	@Autowired
	InsurancePolicyRepository insurancePolicyRepo;
	
	@Override
	public List<InsurancePolicy> getAllInsurancePolicy() {
		// TODO Auto-generated method stub
		return insurancePolicyRepo.findAll();
	}

	@Override
	public Optional<InsurancePolicy> getOneInsurancePolicy(Integer id) {
		// TODO Auto-generated method stub
				 
		Optional<InsurancePolicy> optionalInsurancePolicy = insurancePolicyRepo.findById(id);
		if (optionalInsurancePolicy.isPresent() == false) 
			throw new InsurancePolicyNotFoundException("The id: " + id + " is not found in our database.");
		
		return optionalInsurancePolicy;
	}

	@Override
	public ResponseEntity<HttpStatus> addInsurancePolicy(InsurancePolicy insurancePolicy) {
		// TODO Auto-generated method stub
		insurancePolicyRepo.save(insurancePolicy);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<HttpStatus> updateInsurancePolicy(InsurancePolicy insurancePolicy) {
			
		Optional<InsurancePolicy> optionalInsurancePolicy = insurancePolicyRepo.findById(insurancePolicy.getPolicy_number());
		
		if(optionalInsurancePolicy.isPresent() == false)
			throw new InsurancePolicyNotFoundException("The id: " + insurancePolicy.getPolicy_number() + " is not found in our database.");
		else {
			insurancePolicyRepo.save(insurancePolicy);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<HttpStatus> deleteInsurancePolicy(Integer id) {
		
		Optional<InsurancePolicy> optionalInsurancePolicy = insurancePolicyRepo.findById(id);
		
		if(optionalInsurancePolicy.isPresent() == false)
			throw new InsurancePolicyNotFoundException("The id: " + id + " is not found in our database.");
		else {
			insurancePolicyRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}

	@Override
	public String getPolicyclaimData(Integer id) {
		Optional<InsurancePolicy> optionalInsurancePolicy = insurancePolicyRepo.findById(id);
		
		if (optionalInsurancePolicy.isPresent() == false) 
			throw new InsurancePolicyNotFoundException("The id: " + id + " is not found in our database.");
		
		return optionalInsurancePolicy.get().getClaim().getClaim_data();
	}

}
