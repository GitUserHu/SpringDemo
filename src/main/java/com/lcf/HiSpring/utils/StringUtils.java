package com.lcf.HiSpring.utils;

public class StringUtils {
	
	public static boolean isBlank(String str) {
		
		return str==null||str.length()==0;
	}
	
	/**
	 * all params are not blank
	 * @param strings
	 * @return
	 */
	public static boolean noBlank(String...strings ) {
		for(String str:strings) {
			return !isBlank(str);
		}
		return true;
		
	}
}
