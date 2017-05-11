package test.ut_util;

import static org.junit.Assert.*;

import org.junit.Test;

import util.TLS_Security;
import util.TLS_UDF;

public class UT_TLS_Security {

	@Test
	public void testSHA1() {
		String str = "Darwin";
		String md5Hash = TLS_Security.getHash(str, "md5");
		TLS_UDF.clog(md5Hash);
		//24f39a2ea2308bc942f58fcff965f406 -- uname | openssl md5
		
		//0fc09dc308ca8159ed485d2c5aad6139eab3d44b  -- uname | openssl sha1
		
		assertTrue(md5Hash.equals("24f39a2ea2308bc942f58fcff965f406"));
	}

}
