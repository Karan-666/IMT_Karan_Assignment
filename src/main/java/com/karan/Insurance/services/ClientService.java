package com.karan.Insurance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karan.Insurance.entity.Client;

@Service
public interface ClientService {
	public List<Client> getAllClients();

	public Optional<Client> getOneClient(Integer id);

	public ResponseEntity<HttpStatus> addClient(Client client);

	public ResponseEntity<HttpStatus> updateClient(Client client);

	public ResponseEntity<HttpStatus> deleteClient(Integer id);
	
	public Integer getOneClientPolicyCount(Integer id);
}
