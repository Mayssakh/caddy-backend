package com.javasimpleapp.springrest.postgresql.repo;



import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javasimpleapp.springrest.postgresql.model.Commande;

@Repository
public interface CommandeRepostory extends CrudRepository<Commande, Long>{
	List<Commande> findByNumero(String numero);
}

