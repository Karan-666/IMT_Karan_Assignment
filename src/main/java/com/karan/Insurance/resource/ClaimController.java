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

import com.karan.Insurance.entity.Claim;
import com.karan.Insurance.services.ClaimService;

@RestController
public class ClaimController {

	@Autowired
	ClaimService claimDao;

	@GetMapping("/api/claims")
	public List<Claim> getAllClaim() {
		return claimDao.getAllClaims();
	}

	@GetMapping("/api/claims/{id}")
	public Optional<Claim> getOneClaim(@PathVariable Integer id) {
		return claimDao.getOneClaim(id);
	}

	@PostMapping("/api/claims")
	public ResponseEntity<HttpStatus> addClaim(@RequestBody Claim claim) {
		return claimDao.addClaim(claim);
	}

	@PutMapping("/api/claims")
	public ResponseEntity<HttpStatus> updateClaim(@RequestBody Claim claim) {
		return claimDao.updateClaim(claim);
	}

	@DeleteMapping("/api/claims/{id}")
	public void deleteClaim(@PathVariable Integer id) {
		claimDao.deleteClaim(id);
	}

}
