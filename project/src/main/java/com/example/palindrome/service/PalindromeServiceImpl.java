package com.example.palindrome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.palindrome.model.StringPalingdrome;
import com.example.palindrome.repository.PalindromeRepository;

public class PalindromeServiceImpl implements PalindromeService {
	
	@Autowired
	PalindromeRepository palindromeRepository;

	boolean isPalindrome[][];

	private String getLongestPalindrome(String input) {
		if (input == null || input.isEmpty())
			return "";

		int lengthOfInput = input.length();
		char[] inputCharArray = input.toCharArray();

		int max = 1;
		int start = 0;

		//Below for loop is for substring with length 1 and 2
		for (int i = 0; i < lengthOfInput; i++) {
			isPalindrome[i][i] = true;

			if (i < lengthOfInput - 1 && inputCharArray[i] == inputCharArray[i + 1]) {
				
				isPalindrome[i][i + 1] = true;
				max = 2;
				start = i;
			}
		}

		// for substring of length 3 and more
		for (int j = 2; j < lengthOfInput; j++) {
			for (int i = 0; i < lengthOfInput; i++) {
				if (i + j < lengthOfInput && inputCharArray[i] == inputCharArray[i + j] && isPalindrome[i + 1][i + j - 1]) {
					isPalindrome[i][i + j] = true;
					if (j + 1 > max) {
						max = j + 1;
						start = i;
					}
				}
			}
		}
		return input.substring(start, start + max);

	}
	
	public String checkAndInsertPalindrome(String inputStr)
	{
		String longestPolindromeString = getLongestPalindrome(inputStr);
		StringPalingdrome strPalindrome = new StringPalingdrome();
		
		List<StringPalingdrome> strPalingList;
		//Below condition is for the first time
		if(palindromeRepository.count() == 0)
		{
			strPalindrome.setPalindromeString(longestPolindromeString);
			palindromeRepository.save(strPalindrome);	
			return longestPolindromeString;
		}
		else  
		{
		strPalingList = palindromeRepository.findAll();
		strPalindrome = strPalingList.get(0);
		if(strPalindrome.getPalindromeString().length() < longestPolindromeString.length())
		{
			strPalindrome.setPalindromeString(longestPolindromeString);
			palindromeRepository.deleteAll();
			palindromeRepository.save(strPalindrome);
		}
		return longestPolindromeString;
		}

	}

}
