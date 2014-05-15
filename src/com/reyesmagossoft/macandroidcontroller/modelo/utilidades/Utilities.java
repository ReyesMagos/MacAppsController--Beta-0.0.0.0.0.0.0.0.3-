package com.reyesmagossoft.macandroidcontroller.modelo.utilidades;

public class Utilities {
	
	public static boolean  checkStringToText(String s){
		try{
			Integer.parseInt(s);
			
		}catch(Exception e ){
			return false;
		}
		return true;
	}

}
