package com.app.customException;

public class ValueNotValidException extends RuntimeException {
	
	public ValueNotValidException(String msg)
	{
		super(msg);
	}
}
