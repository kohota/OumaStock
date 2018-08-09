package com.gestionStock.Utility;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Utile {

	public static String getNextCodeDossiers(){
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssS");
		String code = "C"+df.format(new Date());
		
		return code;
	}
}
