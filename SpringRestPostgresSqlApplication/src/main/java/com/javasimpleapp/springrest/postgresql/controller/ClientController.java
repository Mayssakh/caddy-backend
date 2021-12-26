package com.javasimpleapp.springrest.postgresql.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javasimpleapp.springrest.postgresql.model.Client;
import com.javasimpleapp.springrest.postgresql.repo.ClientRepostory;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api")

public class ClientController {
    
	@Autowired
	ClientRepostory repository;
	
	@GetMapping("/client")
	public List<Client> getAllClients(){
		System.out.println("Get All Clients");
		
		List<Client> clients=new ArrayList<>();
		repository.findAll().forEach(clients::add);
		
		return clients;
	}
	@PostMapping(value="/client/create")
	public Client postClient(@RequestBody Client client) {
		Client _client=repository.save(new Client(client.getId(),client.getCode(), client.getNom(),client.getPrenom(),client.getDateNaissance(), client.getAdresse(),client.getVille(),client.getCodePostal(),client.getTel(), client.getFax(), client.getGsm(), client.getEmail()));
		return _client;
	}
	
	@DeleteMapping("/client/{id}")
	public ResponseEntity<String>deleteClient(@PathVariable("id") long id){
		System.out.println("delete Client with id =" +id + "...");
		repository.deleteById(id);
		
		return new ResponseEntity<>("client has be deleted!",HttpStatus.OK);
	}
	@GetMapping(value="client/code/{code}")
	public List<Client> findByCode(@PathVariable String code){
		List<Client> clients=repository.findByCode(code);
		return clients;
	}
	@PutMapping("/client/{id}")
	public ResponseEntity<Client>updateClient(@PathVariable("id")long id,@RequestBody Client client){
		System.out.println("Update Client with Id "+id+"..");
		
		Optional<Client> clientData=repository.findById(id);
		
		if(clientData.isPresent()) {
			Client _client=clientData.get();
			_client.setCode(client.getCode());
			_client.setNom(client.getNom());
			_client.setPrenom(client.getPrenom());
			_client.setDateNaissance(client.getDateNaissance());
			_client.setAdresse(client.getAdresse());
			_client.setVille(client.getVille());
			_client.setCodePostal(client.getCodePostal());
			_client.setTel(client.getTel());
			_client.setFax(client.getTel());
			_client.setGsm(client.getGsm());
			_client.setEmail(client.getEmail());
			return new ResponseEntity<>(repository.save(_client),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	
} 
