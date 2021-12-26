package com.javasimpleapp.springrest.postgresql.repo;

	

	import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.javasimpleapp.springrest.postgresql.model.Client;

	@Repository
	public interface ClientRepostory extends CrudRepository<Client, Long>{
		List<Client> findByCode(String code);
	}
	

