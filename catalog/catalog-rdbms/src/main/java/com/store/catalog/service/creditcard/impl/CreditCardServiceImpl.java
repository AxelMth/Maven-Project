package com.store.catalog.service.creditcard.impl;

import com.store.catalog.model.CreditCardDTO;
import com.store.catalog.model.VerifCCResult;
import com.store.catalog.service.creditcard.CreditCardService;

/**
 * Created by zouheir on 02/12/2016.
 */
public class CreditCardServiceImpl implements CreditCardService {


    public boolean verifyCreditCard(final CreditCardDTO creditCardDto) throws NumberFormatException {
        
    	Integer.parseInt(creditCardDto.getCreditCardNumber());
    	
    	String numbers = creditCardDto.getCreditCardNumber();
    	int sum = 0;
    	int nDigits = numbers.length();
    	//int parity = nDigits & 1;
    	char[] charNumbers = numbers.toCharArray();
    	sum += Character.getNumericValue(charNumbers[nDigits-1]);
    	
    	for (int i = 0; i < nDigits-1; i++){
    		int digit = Character.getNumericValue(charNumbers[i]);
    		if (i%2 == 0)
    			digit *= 2;
    		if (digit > 9)
    			digit -= 9;
    		sum += digit;
    	}
    	int i = sum%10;
    	if(i==0)
    		return true;
    	else 
    		return false;
    }
    
}
