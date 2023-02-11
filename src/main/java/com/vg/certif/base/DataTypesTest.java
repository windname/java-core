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

		// undescore for literals
		float f = 100_000_000.00f;

		double d1 = 123.4;
		double d2 = 1.234e2; // scientific notation!!
		float f1 = 123.4f;
		float f2 = 123.4F;

		// literals
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

		// autoboxing
		Integer cnt = 120;
		int num = 100;
		Integer numbWrap = Integer.valueOf(num);

		//unboxing
		Character charWrapper = Character.valueOf('c');
		char c = charWrapper;

	}

	public void primitiveAssign() {
		byte b = 1;
		short s = 1;
		int i = 1;
		long lo = 1212l;
		float f = 3.14f;
		double d = 3.14;
		char c = 'a';

//		byte = c;

		// auto cast to short
		s = b;

		// cast to int
		i = s; i = b; i= c;

		// cast to long
		lo = s; lo = b; lo = i; lo = c;

		// cast to float
		f = s; f = b; f= i; f = lo; f = c;

		// cast to double
		d = f; d = s; d = b; d = i; d = lo; d = c;

//		c = b;
		c = 1;

	}

	public void primitiveCast() {
		byte b = (byte) 1;
		b = (short) 1;
		b = 1;//int (-128 to 127)
		b = (int) 1L;
		b = (int) 1.2345f;
		b = (int) 1.245;
		b = 'a'; //97

		short s = (byte) 1;
		s = (short) 1;
		s = 1; //int (-32,768 to 32,767)
		s = (int) 1L;
		s = (int) 1.2345f;
		s = (int) 1.245;
		s = 'a';

		s = b;

		char c = 'a';
		Character charWrap = Character.valueOf('v');
		c = (char)b;
		charWrap = (char)b;
	}

	public void numericTypePromotion() {
		int i = 10; long l = 3;
		var res = i*l; // res promoted to long

		short s1 = 10; short s2 = 20;
		 var s3 = s1*s2; // promoted to int

		short s4 = 10 * 20;

	}

	public void stringMethods() {
		String str = "Hello";
		str.length();
		char c = str.charAt(0);
	}
}
