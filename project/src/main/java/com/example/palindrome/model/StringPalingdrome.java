package com.example.palindrome.model;

import javax.persistence.Entity;

@Entity
public class StringPalingdrome {
	
	String palindromeString;

	public String getPalindromeString() {
		return palindromeString;
	}

	public void setPalindromeString(String palindromeString) {
		this.palindromeString = palindromeString;
	}
	
	

}
