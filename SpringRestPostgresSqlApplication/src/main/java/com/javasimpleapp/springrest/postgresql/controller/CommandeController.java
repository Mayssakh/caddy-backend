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

	import com.javasimpleapp.springrest.postgresql.model.Commande;
	import com.javasimpleapp.springrest.postgresql.repo.CommandeRepostory;

	@CrossOrigin(origins="http://localhost:4200")
	@RestController
	@RequestMapping("/api")

	public class CommandeController {
	    
		@Autowired
		CommandeRepostory repository;
		
		@GetMapping("/commande")
		public List<Commande> getAllClients(){
			System.out.println("Get All Commande");
			
			List<Commande> commandes=new ArrayList<>();
			repository.findAll().forEach(commandes::add);
			
			return commandes;
		}
		@PostMapping(value="/commande/create")
		public Commande postCommande(@RequestBody Commande commande) {
			Commande _commande=repository.save(new Commande(commande.getId(),commande.getNumero(),commande.getDate(),commande.getPrixtotal(),commande.getEtat()));
			return _commande;
		}
		@DeleteMapping("/commande/{id}")
		public ResponseEntity<String>deleteCommande(@PathVariable("id") long id){
			System.out.println("delete Commande with id =" +id + "...");
			repository.deleteById(id);
			
			return new ResponseEntity<>("commande has be deleted!",HttpStatus.OK);
		}
		@GetMapping(value="commande/numero/{numero}")
		public List<Commande> findByNumero(@PathVariable String numero){
			List<Commande> commandes=repository.findByNumero(numero);
			return commandes;
		}
		@PutMapping("/commande/{id}")
		public ResponseEntity<Commande>updateCommande(@PathVariable("id")long id,@RequestBody Commande commande){
			System.out.println("Update commande with Id "+id+"..");
			
			Optional<Commande> commandeData=repository.findById(id);
			
			if(commandeData.isPresent()) {
				Commande _commande=commandeData.get();
				_commande.setNumero(commande.getNumero());
				_commande.setDate(commande.getDate());
				_commande.setPrixtotal(commande.getPrixtotal());
				_commande.setEtat(commande.getEtat());
				
				
				return new ResponseEntity<>(repository.save(_commande),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		
	} 

	




