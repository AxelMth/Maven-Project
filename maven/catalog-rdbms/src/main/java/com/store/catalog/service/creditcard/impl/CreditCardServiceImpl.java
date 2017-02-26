package com.store.catalog.service.creditcard.impl;

import com.store.catalog.model.CreditCardDTO;
import com.store.catalog.model.VerifCCResult;
import com.store.catalog.service.creditcard.CreditCardService;

/**
 * Created by zouheir on 02/12/2016.
 */
public class CreditCardServiceImpl implements CreditCardService {

    public VerifCCResult verifyCreditCard(final CreditCardDTO creditCardDto) throws NumberFormatException {
        
    	// La chaîne contenant le numéro de carte
    	String numbersString = creditCardDto.getCreditCardNumber();
    	// On sépare les espaces entre les numéros puis on vérifie que les chaînes séparées ne 
    	// contiennent que des chiffres
    	String[] numbersStringArray = numbersString.split(" ");
    	
    	// Chaîne finale sans les espaces
    	String numbers = "";
    	
    	for (int count = 0; count < numbersStringArray.length; count++){
        	// NumberFormatException - if the String does not contain a parsable long. (JavaDoc)
    		Long.parseLong(numbersStringArray[count]);
    		numbers = numbers.concat(numbersStringArray[count]);
    	}
    	
    	// On initialise la somme
    	int sum = 0;
    	
    	//Longueur du numéro de carte
    	int nDigits = numbers.length();
    	char[] charNumbers = numbers.toCharArray();
    	
    	// On parcours tous les chiffres contenus dans le numéro de la carte
    	// Et on applique l'algorithme de Luhn
    	for (int i = 0; i < nDigits; i++){
    		// On prend la valeur de chaque chiffre de la carte (char) et on les cast en int 
    		// Pour pouvoir faire la somme
    		int digit = Character.getNumericValue(charNumbers[i]);
    		
    		if (i%2 == 0)
    			digit *= 2;
    		
    		if (digit > 9)
    			digit -= 9;
    		
    		sum += digit;
    	}
    	
    	// Si c'est un multiple de 10 OK !
    	if(sum%10==0)
    		return VerifCCResult.OK;
    	else 
    		return VerifCCResult.KO;
    }
    
}
