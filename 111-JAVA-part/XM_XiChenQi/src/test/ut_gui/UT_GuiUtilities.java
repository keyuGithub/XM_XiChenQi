package test.ut_gui;

import static org.junit.Assert.*;

import org.junit.Test;

import gui.GUI_Utilities;

public class UT_GuiUtilities {

	@Test
	public void test() {
		String pwd = "1234567";
		String readPwd = GUI_Utilities.readPwd();

		assertTrue(readPwd.equals(pwd));
	}

}
