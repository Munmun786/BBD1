package utils;

import java.security.PublicKey;
import java.util.Date;

public class CommonUtils {
	
	public static final int IMPLICIT_WAIT_TIME=10;
	public static final int PAGELOAD_WAIT_TIME=15;
	public static final int EXPLICIT_WAIT_TIME=20;

	public static String getEmailWIthTimeStamp() {
		  Date date=new Date();
		  return "munmun"+ date.toString().replace(" ", "_").replace(":", "_")+"@gmail.com";
	}
	
	
}
