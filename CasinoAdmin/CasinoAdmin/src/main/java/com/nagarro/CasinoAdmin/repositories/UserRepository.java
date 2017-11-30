package com.nagarro.CasinoAdmin.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.nagarro.CasinoAdmin.models.UserDetails;

public interface UserRepository extends CrudRepository<UserDetails, Long> {

	public UserDetails findByUid(String uid); 
	public List<UserDetails> findByNameOrNumberOrEmail(String name, String number, String email );
	public List<UserDetails> findByNameIgnoreCaseContainsAndNumberIgnoreCaseContainsAndEmailIgnoreCaseContains(String name, String number, String email );
}
