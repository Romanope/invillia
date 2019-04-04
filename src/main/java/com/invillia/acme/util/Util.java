package com.invillia.acme.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.invillia.acme.exceptions.BusinessException;

@Component
public class Util {

	
	private static final String YYYY_MM_DD_T_HH_MM_SS = "yyyy-MM-dd'T'HH:mm:ss";

	public Date parse (String date) throws BusinessException {
		
		DateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD_T_HH_MM_SS);	
	
		try {
			return dateFormat.parse(date);
		} catch (ParseException e) {
			throw new BusinessException("Erro parse date", e);
		}
	}

	public String format (Date date) throws BusinessException {
		
		DateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD_T_HH_MM_SS);	
		
		return dateFormat.format(date);
	}
}
