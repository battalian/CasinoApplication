package com.nagarro.CasinoAdmin.controllers;


import java.io.Console;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.nagarro.CasinoAdmin.annotation.UsernameValidator;
import com.nagarro.CasinoAdmin.models.LoginResponse;
import com.nagarro.CasinoAdmin.models.UpdateProfit;
import com.nagarro.CasinoAdmin.models.UserDetails;
import com.nagarro.CasinoAdmin.repositories.UserRepository;
import com.nagarro.CasinoAdmin.services.CasinoAdminService;

@CrossOrigin
@Controller

public class CasinoAdminController {


	private CasinoAdminService service;

	@RequestMapping("/admin/home")
	public String home() {
		return "home";
	}

	@Autowired
	public CasinoAdminController(CasinoAdminService service) {
		super();
		this.service = service;
	}

	@GetMapping("/admin/register")
	public String register() {
		System.out.println("entered");
		return "register";
	}
	
	@PostMapping("/admin/addContent")
	public String addContent ( @RequestParam("name") String name, 
			@RequestParam("email") String email,
			@RequestParam("number") String number, 
			@RequestParam("dob") @DateTimeFormat(pattern="yyyy-MM-dd") Date dob,
			@RequestParam("file") MultipartFile file) {
		
		System.out.println(name);
		System.out.println(email);
		System.out.println(number);
		System.out.println(dob);
		return service.addContent(name,  email, number, dob, file);
	}

	@GetMapping(path="/admin/userLists")
	public String getAllUsers(Model model) {
		return service.getAllUsers(model);
	}

	@RequestMapping(value = "/admin/addAmount", method = RequestMethod.POST)
	public String addAmount (@RequestParam("id") Long id, 
			@RequestParam("amount") Double amount, Model model) {

		System.out.println(amount);
		System.out.println(id);
		return service.addAmount(id, amount, model);
	}


	@RequestMapping(value = "/admin/handlingSearch", method = RequestMethod.POST)
	public String handlingSearch (@RequestParam("name") String name, 
			@RequestParam("email") String email,
			@RequestParam("number") String number, Model model) {

		return service.handlingSearch(name, email, number, model);
	}


	@RequestMapping(value = "api/getUserByUid", method=RequestMethod.POST)
	public @ResponseBody LoginResponse getUserByUid(@RequestParam("uid") String uid) {
		return service.getUserByUid(uid);
	}

	@RequestMapping(value = "api/userDetailsByUid", method=RequestMethod.POST)
	public @ResponseBody UserDetails userDetailsByUid(@RequestParam("uid") String uid) {
		return service.userDetailsByUid(uid);
	}

	@RequestMapping(value = "api/getUserById", method=RequestMethod.POST)
	public @ResponseBody UserDetails getUserById(@RequestParam("id") Long id) {
		return service.getUserById(id);
	}

	@RequestMapping(value = "api/updateAmountWithId", method=RequestMethod.POST)
	public void updateAmountWithId(@RequestBody UpdateProfit bet ) {
		System.out.println("entered updateWithId");
		System.out.println(bet.getId());
		System.out.println(bet.getProfit());
		service.updateAmountWithId(bet.getId(), bet.getProfit());
	}


	@RequestMapping(value = "api/updateBlockedAmountWithId", method=RequestMethod.POST)
	public void updateBlockedAmountWithId(@RequestBody UpdateProfit bet ) {
		System.out.println("entered updateWithId");
		System.out.println( bet.getId() );
		System.out.println(bet.getProfit());
		service.updateBlockedAmountWithId(bet.getId(), bet.getProfit());
	}
}
