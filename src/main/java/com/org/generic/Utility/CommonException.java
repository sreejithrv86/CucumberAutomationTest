package com.org.generic.Utility;

public class CommonException extends Exception{
	
	CommonException(String message){
		super(message);
	}
	
	CommonException(String message, String value){
		super(message.replace("{0}", value));
	}
	
	CommonException(String message, String firstValue, String secondValue){
		super(message.replace("{0}", firstValue).replace("{1}", secondValue));
	}
	
	CommonException(String message, String firstValue, String secondValue, String thirdValue){
		super(message.replace("{0}", firstValue).replace("{1}", secondValue).replace("{2}", thirdValue));
	}


}
