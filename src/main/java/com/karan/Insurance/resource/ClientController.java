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

import com.karan.Insurance.entity.Client;
import com.karan.Insurance.services.ClientService;

@RestController
public class ClientController {

	@Autowired
	ClientService clientDao;

	// get all Clients
	@GetMapping("/api/clients")
	public List<Client> getAllClient() {
		return clientDao.getAllClients();
	}

	// get single client
	@GetMapping("/api/clients/{id}")
	public Optional<Client> getOneClient(@PathVariable Integer id) {
		return clientDao.getOneClient(id);
	}

	@PostMapping("/api/clients")
	public ResponseEntity<HttpStatus> addClient(@RequestBody Client client) {
		return clientDao.addClient(client);
	}

	@PutMapping("/api/clients")
	public ResponseEntity<HttpStatus> updateClient(@RequestBody Client client) {
		return clientDao.updateClient(client);
	}

	@DeleteMapping("/api/clients/{id}")
	public void deleteClient(@PathVariable Integer id) {
		clientDao.deleteClient(id);
	}
	
	@GetMapping("/api/clients/{id}/policy-count")
	public Integer getOneClientPolicyCount(@PathVariable Integer id) {
		
		return clientDao.getOneClientPolicyCount(id);
	}

}
