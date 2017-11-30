package com.nagarro.CasinoGame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nagarro.CasinoGame.models.RouletteResult;
import com.nagarro.CasinoGame.services.CasinoGameService;

@CrossOrigin
@Controller
public class CasinoGameController {
	
	private CasinoGameService service;
	
	@Autowired
	public CasinoGameController(CasinoGameService service) {
		super();
		this.service = service;
	}

	@PostMapping("/showResult")
	@ResponseBody
	public ResponseEntity<RouletteResult> showResult ( @RequestParam("num1") Integer num1,
			@RequestParam("num2") Integer num2,
			@RequestParam("num3") Integer num3,
			@RequestParam("num4") Integer num4,
			@RequestParam("num5") Integer num5,
			@RequestParam("num6") Integer num6,
			@RequestParam("num7") Integer num7,
			@RequestParam("num8") Integer num8,
			@RequestParam("id") Long id
			) {
		System.out.println("In show results");
//		return service.showResult(num1, num2, num3, num4, num5, num6, num7, num8);
		return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON)
				.body( service.showResult(num1, num2, num3, num4, num5, num6, num7, num8, id) );
		}
}
