package com.karan.Insurance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.karan.Insurance.entity.Claim;
import com.karan.Insurance.entity.Client;

@Repository
public interface ClaimRepository extends JpaRepository<Claim, Integer> {
	
	
}
