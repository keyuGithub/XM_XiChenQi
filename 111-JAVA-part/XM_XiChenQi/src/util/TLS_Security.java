package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TLS_Security {

	public static String getHash(String txt, String hashFunc) {
		Runtime rt = Runtime.getRuntime();
		String[] commands = {"/bin/sh", "-c", "echo " + txt + "| openssl " + hashFunc};
//		String[] commands = {"/bin/sh", "-c", "echo " + txt + "| " + hashFunc};

		String output = null; 
		try {
			Process proc = rt.exec(commands);
//			Process proc = new ProcessBuilder("echo " + txt, " | openssl " + hashFunc).start();
			
			BufferedReader stdInput = new BufferedReader(new InputStreamReader(proc.getInputStream()));
			BufferedReader stdError = new BufferedReader(new InputStreamReader(proc.getErrorStream()));
			
			//read the output from the command
//			TLS_UDF.clog("Here is the standrad output of the command:\n");
			String msg = null;
			output = stdInput.readLine();
			while ((msg = stdInput.readLine()) != null) {
//				TLS_UDF.clog(msg);
			}
/*			
			//read the output from the command
			TLS_UDF.clog("Here is the standrad error of the command (if any):\n");
			String error = null;
			while ((error = stdError.readLine()) != null) {
				TLS_UDF.clog(error);
			}
*/
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return output;		
		
	}
	/*
	public static String getHash(String txt, String hashType){
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
			md.update(txt.getBytes(), 0, txt.length());
			//md.update(txt.getBytes(Charset.forName("UTF8")));
			BigInteger bigInt = new BigInteger(1, md.digest());
			String result = String.format("%032x",  bigInt);
			return result;
		} catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}*/
}
