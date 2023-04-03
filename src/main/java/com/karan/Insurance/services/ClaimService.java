package com.karan.Insurance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karan.Insurance.entity.Claim;
import com.karan.Insurance.entity.Client;

@Service
public interface ClaimService {
	public List<Claim> getAllClaims();

	public Optional<Claim> getOneClaim(Integer id);

	public ResponseEntity<HttpStatus> addClaim(Claim claim);

	public ResponseEntity<HttpStatus> updateClaim(Claim claim);

	public ResponseEntity<HttpStatus> deleteClaim(Integer id);
}
