package com.karan.Insurance.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.karan.Insurance.entity.Client;
import com.karan.Insurance.exception.ClientNotFoundException;
import com.karan.Insurance.repository.ClientRepository;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	ClientRepository clientRepo;
	
	@Override
	public List<Client> getAllClients() {
		// TODO Auto-generated method stub
		return clientRepo.findAll();
	}

	@Override
	public Optional<Client> getOneClient(Integer id) {
		// TODO Auto-generated method stub
				 
		Optional<Client> optionalClient = clientRepo.findById(id);
		if (optionalClient.isPresent() == false) 
			throw new ClientNotFoundException("The id: " + id + " is not found in our database.");
		
		return optionalClient;
	}

	@Override
	public ResponseEntity<HttpStatus> addClient(Client client) {
		// TODO Auto-generated method stub
		clientRepo.save(client);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<HttpStatus> updateClient(Client client) {
			
		Optional<Client> optionalClient = clientRepo.findById(client.getId());
		
		if(optionalClient.isPresent() == false)
			throw new ClientNotFoundException("The id: " + client.getId() + " is not found in our database.");
		else {
			clientRepo.save(client);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<HttpStatus> deleteClient(Integer id) {
		
		Optional<Client> optionalClient = clientRepo.findById(id);
		
		if(optionalClient.isPresent() == false)
			throw new ClientNotFoundException("The id: " + id + " is not found in our database.");
		else {
			clientRepo.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
	}

	@Override
	public Integer getOneClientPolicyCount(Integer id) {
		
		Optional<Client> optionalClient = clientRepo.findById(id);
		
		if (optionalClient.isPresent() == false) 
			throw new ClientNotFoundException("The id: " + id + " is not found in our database.");
		
		return optionalClient.get().getPolicyList().size();
			
	}

}
