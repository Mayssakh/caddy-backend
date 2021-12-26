package com.javasimpleapp.springrest.postgresql.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javasimpleapp.springrest.postgresql.model.Produit;


@Repository
public interface ProduitRepostory extends CrudRepository<Produit, Long>{
	List<Produit> findByCode(String code);

}
