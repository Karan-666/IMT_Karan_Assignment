package com.karan.Insurance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karan.Insurance.entity.Claim;
import com.karan.Insurance.exception.ClaimNotFoundException;
import com.karan.Insurance.repository.ClaimRepository;

@Service
public class ClaimServiceImpl implements ClaimService {
	
	@Autowired
	ClaimRepository claimRepo;
	
	@Override
	public List<Claim> getAllClaims() {
		// TODO Auto-generated method stub
		return claimRepo.findAll();
	}

	@Override
	public Optional<Claim> getOneClaim(Integer id) {
		// TODO Auto-generated method stub
				 
		Optional<Claim> optionalClaim = claimRepo.findById(id);
		if (optionalClaim.isPresent() == false) 
			throw new ClaimNotFoundException("The id: " + id + " is not found in our database.");
		
		return optionalClaim;
	}

	@Override
	public ResponseEntity<HttpStatus> addClaim(Claim claim) {
		// TODO Auto-generated method stub
		claimRepo.save(claim);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<HttpStatus> updateClaim(Claim claim) {
			
		Optional<Claim> optionalClaim = claimRepo.findById(claim.getClaim_number());
		
		if(optionalClaim.isPresent() == false)
			throw new ClaimNotFoundException("The id: " + claim.getClaim_number() + " is not found in our database.");
		else {
			claimRepo.save(claim);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<HttpStatus> deleteClaim(Integer id) {
		
		Optional<Claim> optionalClaim = claimRepo.findById(id);
		
		if(optionalClaim.isPresent() == false)
			throw new ClaimNotFoundException("The id: " + id + " is not found in our database.");
		else {
			claimRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}

}
