/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.base;

import java.util.regex.Pattern;

/**
 * 
 * @author vladimir
 */
public class DataTypesTest {

	public static void main(String[] args) {
		int decVal = 26;
		int hexVal = 0x1a; // The number 26, in hexadecimal
		int binVal = 0b11010; // The number 26, in binary
		int octVal = 032; // The number 26, in octodecimal
		final long longNumber = 013; // 11
		byte b = 127;
		System.out.println(octVal);

		double d1 = 123.4;
		double d2 = 1.234e2; // scientific notation!!
		float f1 = 123.4f;
		float f2 = 123.4F;

		long creditCardNumber = 1234_5678_9012_3456L;
		long maxLong = 0x7fff_ffff_ffff_ffffL;
		long bytes = 0b11010010_01101001_10010100_10010010;
		float pi = 3.14_15F;

		// String filter = "catalina.*log";

		String filter = "localhost\\..*\\.log\\.zip";
		String name = "localhost.12-123.log.zip";
		// String filter = "catalina\\..*\\.log\\.zip";
		// String name = "catalina.12-123.log.zip";
		boolean rez = Pattern.compile(filter).matcher(name).matches();
		System.out.println(name + " matches " + filter + " " + rez);

	}
}
