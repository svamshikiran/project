package com.example.binaryconversion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.binaryconversion.service.BinaryConversionService;

@RestController
@RequestMapping("/binary")
public class BinaryConversionController {
	
	@Autowired
	BinaryConversionService binaryService;
	
	@GetMapping(value = "/{decimalNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
	public String reverseBinaryNumber(@PathVariable("decimalNumber") String decimalNumber) {
		
		return binaryService.binaryConversion(decimalNumber);
		
	}
	
	

}
