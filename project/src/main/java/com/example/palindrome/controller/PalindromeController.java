package com.example.palindrome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.palindrome.service.PalindromeService;

@RestController
@RequestMapping("/palindrome")
public class PalindromeController {
	
	@Autowired
	PalindromeService palindromeService;
	
	@PostMapping("/{stringVariable}")
	public String checkAndInsertPalindrome(@PathVariable ("stringVariable") String stringVariable) {
		
		return palindromeService.checkAndInsertPalindrome(stringVariable);
		
	}

}
