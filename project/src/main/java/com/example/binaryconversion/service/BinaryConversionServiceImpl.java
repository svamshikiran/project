package com.example.binaryconversion.service;

public class BinaryConversionServiceImpl implements BinaryConversionService{
	
	public String binaryConversion(String inputStr) {
		
		String binaryNumber = Integer.toBinaryString(Integer.parseInt(inputStr));
		if(binaryNumber.length() < 8) {
			String.format("%08d", Integer.parseInt(binaryNumber));
		}
		
		return ""+Integer.parseInt((new StringBuilder().append(binaryNumber).reverse().toString()), 2);
	}

}
