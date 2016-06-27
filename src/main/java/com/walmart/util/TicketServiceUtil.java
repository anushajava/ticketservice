package com.walmart.util;

import java.util.Optional;

/**
 * The class <code>TicketServiceUtil</code> contains utility methods.
 * 
 * @author ANUSHA
 */
public class TicketServiceUtil {

	/**
	 * This method is to convert int to Optional parameter
	 * @param value
	 * @return Optional variable
	 */
	public static Optional<Integer> convertToOptional(int value){
		Optional<Integer> optionalValue=Optional.of(new Integer(value));
		return optionalValue;
	}
	
	/**
	 * This method validates Customer Email
	 * @param eMail
	 * @return true or false
	 */
	public static boolean emailIdValidation(String customerEmail){
		String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		if(customerEmail.matches(EMAIL_REGEX)){
			return true;
		}
		return false;
	}
}
