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

	import com.javasimpleapp.springrest.postgresql.model.Produit;
	import com.javasimpleapp.springrest.postgresql.repo.ProduitRepostory;

	@CrossOrigin(origins="http://localhost:4200")
	@RestController
	@RequestMapping("/api")

	public class ProduitController {
	    
		@Autowired
		ProduitRepostory repository;
		
		@GetMapping("/produit")
		public List<Produit> getAllClients(){
			System.out.println("Get All Produit");
			
			List<Produit> produits=new ArrayList<>();
			repository.findAll().forEach(produits::add);
			
			return produits;
		}
		@PostMapping(value="/produit/create")
		public Produit postProduit(@RequestBody Produit produit) {
			Produit _produit=repository.save(new Produit(produit.getLibelle(),produit.getId(),produit.getCode(),produit.getMarque(),produit.getModele(),produit.getCaracteristique(),produit.getPrixunitaire(),produit.getQuantite()));
			return _produit;
		}
		@DeleteMapping("/produit/{id}")
		public ResponseEntity<String>deleteProduit(@PathVariable("id") long id){
			System.out.println("delete Produit with id =" +id + "...");
			repository.deleteById(id);
			
			return new ResponseEntity<>("produit has be deleted!",HttpStatus.OK);
		}
		@GetMapping(value="produit/code/{code}")
		public List<Produit> findByCode(@PathVariable String code){
			List<Produit> produits=repository.findByCode(code);
			return produits;
		}
		@PutMapping("/produit/{id}")
		public ResponseEntity<Produit>updateProduit(@PathVariable("id")long id,@RequestBody Produit produit){
			System.out.println("Update Produit with Id "+id+"..");
			
			Optional<Produit> produitData=repository.findById(id);
			
			if(produitData.isPresent()) {
				Produit _produit=produitData.get();
				_produit.setCode(produit.getCode());
				_produit.setMarque(produit.getModele());
				_produit.setModele(produit.getModele());
				_produit.setCaracteristique(produit.getCaracteristique());
				_produit.setPrixunitaire(produit.getPrixunitaire());
				_produit.setQuantite(produit.getQuantite());
				
				return new ResponseEntity<>(repository.save(_produit),HttpStatus.OK);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		
		
	} 

	

