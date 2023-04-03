package com.karan.Insurance.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.karan.Insurance.entity.InsurancePolicy;
import com.karan.Insurance.services.InsurancePolicyService;
import com.karan.Insurance.services.InsurancePolicyService;

@RestController
public class InsurancePolicyController {

	@Autowired
	InsurancePolicyService insurancePolicyDao;

	// get all InsurancePolicy
	@GetMapping("/api/policies")
	public List<InsurancePolicy> getAllInsurancePolicy() {
		return insurancePolicyDao.getAllInsurancePolicy();
	}

	// get single InsurancePolicy
	@GetMapping("/api/policies/{id}")
	public Optional<InsurancePolicy> getOneInsurancePolicy(@PathVariable Integer id) {
		return insurancePolicyDao.getOneInsurancePolicy(id);
	}

	@PostMapping("/api/policies")
	public ResponseEntity<HttpStatus> addInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy) {
		return insurancePolicyDao.addInsurancePolicy(insurancePolicy);
	}

	@PutMapping("/api/policies")
	public ResponseEntity<HttpStatus> updateInsurancePolicy(@RequestBody InsurancePolicy insurancePolicy) {
		return insurancePolicyDao.updateInsurancePolicy(insurancePolicy);
	}

	@DeleteMapping("/api/policies/{id}")
	public void deleteInsurancePolicy(@PathVariable Integer id) {
		insurancePolicyDao.deleteInsurancePolicy(id);
	}
	
	@GetMapping("/api/policies/{id}/claim-data")
	public String getPolicyclaimData(@PathVariable Integer id) {
		return insurancePolicyDao.getPolicyclaimData(id);
	}

}
