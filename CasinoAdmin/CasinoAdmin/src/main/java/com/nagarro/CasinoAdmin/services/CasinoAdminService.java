package com.nagarro.CasinoAdmin.services;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.CasinoAdmin.models.LoginResponse;
import com.nagarro.CasinoAdmin.models.UpdateProfit;
import com.nagarro.CasinoAdmin.models.UserDetails;
import com.nagarro.CasinoAdmin.repositories.UserRepository;

@Service
public class CasinoAdminService {

	private UserRepository repository;

	@Autowired
	public CasinoAdminService(UserRepository repository) {
		super();
		this.repository = repository;
	}

	public String addContent (  String name,  String email,	String number, 	Date dob, MultipartFile file
			) {

		System.out.println("entered Service");
		System.out.println(name);
		System.out.println(email);
		System.out.println(number);
		System.out.println(dob);
		
		
		String fileName = null;
		fileName = file.getOriginalFilename().toString();
		String extension = FilenameUtils.getExtension(fileName);

		System.out.println(extension);
		
//		if( extension.equals( "PNG") || extension.equals( "png")
//				|| extension.equals( "JPG") || extension.equals( "jpg"))
//		{
		UserDetails user= new UserDetails();  
		user.setName(name);
		user.setEmail(email);
		user.setNumber(number);
		user.setDob(dob);
		user.setUid( UUID.randomUUID().toString() );
		user.setAmount(500.00);
		user.setBlockedAmount(0.00);
		user.setImage(fileName);
		
		repository.save(user);

		return "redirect:/admin/userLists";
//		}
		
	}


	public String getAllUsers(Model model) {
		model.addAttribute("users", repository.findAll() );
		return "userList";
	}


	public String addAmount ( Long id, Double amount, Model model) {

		System.out.println(amount);
		System.out.println(id);

		UserDetails user = repository.findOne(id);
		if(user == null) {
			System.out.println("ID not found ");
		}
		System.out.println("total amount");
		System.out.println( amount + user.getAmount() );
		user.setAmount( amount + user.getAmount());

		 repository.save(user);

		return "redirect:/admin/userLists";
	}

	public String handlingSearch (String name,  String email,  String number, Model model) {
		System.out.println("In handling search");
		model.addAttribute("users", repository.findByNameIgnoreCaseContainsAndNumberIgnoreCaseContainsAndEmailIgnoreCaseContains(name, number, email) );
		System.out.println( model.toString() );
		return "userList";

	}

	public @ResponseBody LoginResponse getUserByUid(String uid) {
		System.out.println("finding user");
		if( repository.findByUid(uid) == null) 
			return( new LoginResponse("false"));
		else
			return( new LoginResponse("true"));
	}

	public @ResponseBody UserDetails userDetailsByUid(String uid) {
		return repository.findByUid(uid);
	}

	public @ResponseBody UserDetails getUserById(Long id) {
		return repository.findOne(id);
	}

	public void updateBlockedAmountWithId(Long id, Double block_amount ) {
		System.out.println("entered blockUpdateWithId");

		UserDetails user = repository.findOne(id);
		user.setBlockedAmount(block_amount);
		user.setAmount(user.getAmount()-block_amount);
		repository.save(user);
	}

	public void updateAmountWithId(Long id, Double profit ) {
		UserDetails user = repository.findOne(id);
		if(user == null) {
			System.out.println("ID not found ");
		}

		user.setAmount(profit+ user.getAmount());
		user.setBlockedAmount(0.00);

		repository.save(user);
	}



}
