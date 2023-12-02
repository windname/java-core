/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vg.certif.base;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

		new DataTypesTest().enumTest();

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

		long lo = 120l;
		char c = 'a';
		c = (char)lo;
		Character charWrap = Character.valueOf('v');
		charWrap = (char)lo;
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
		str.length(); //5
		str.substring(1,3); //el
		str.indexOf('e'); // 1
		str.indexOf('l',2); //2
		str.indexOf("lo"); // 3
		char c = str.charAt(0); // string.H
		System.out.println(c);
		str.codePointAt(2); // 108 decimal value from  unicode of the char
		str.equals(new String("Hello")); // true

		StringBuilder build = new StringBuilder("Hello");
		build.append("world"); // Helloworld;
		build.insert(5, ' '); // Hello world
		build.equals(new StringBuilder("Hello World")); // false
		build.compareTo(new StringBuilder("Hello world")); // 0 menas equals from java 11
		build.toString().equals(new StringBuilder("Hello world").toString()); // old way to compare SB
		build.reverse(); // dlrow olleH


	}

	public void useVar() {
		var f = 1.2f;
//		var v = null; // not possible
		var v = (String) null;
//		var a = 3, b = 4; // compound declaration is not allow
		var str = "String";
		str = null;


		for (var i = 0; i < 10; i++) {

		}

		List<String> result = List.of("hello", "how", "are", "you", "?");
		var stringsList = List.of("hello", "how", "are", "you", "?"); // how it works?
		var list1 = new ArrayList<>();

		//Whole number inferred as integer
		byte flags = 0;
		short mask = 0x7fff;
		long base = 17;

		var flags1 = 0; //int
		var mask1 = 0x7fff;//int
		var base1 = 17;//int

		BiFunction<Integer,Integer,String> f2 = (var a, var b) -> "Hello";
//		BiFunction<Integer,Integer,String> f1 = (var a,  b) -> "Hello"; //wrong! issue with b param
		BiFunction<Integer,Integer,String> f1 = (Integer a, Integer b) -> "Hello";
//		BiFunction<Integer,Integer,String> f3 = (var a, Integer b) -> "Hello"; // wrong! mix of decalartions




		//NonDenotable Anonymous Class
		var productInfo = new Object() {
			String name = "Apple";
			int total = 0;
		};

		// NonDenotable Intersection Type
		var action = (Function<Integer, Integer> & Serializable) i -> i + 1;

	}

	// is not keyword and possible to use as method name
	private void var()
	{
		System.out.println("Using var as method name");
	}

	{
		var num = 1.0;
	}

	enum Day {
		SUNDAY("sun"), MONDAY("mon");
		private String str;
		Day(String str) {
			this.str = str;
		}
	}
	private void enumTest() {
		Day d = Day.MONDAY;
		for (var day : Day.values()) {
			System.out.println(day.str);
		}

		var countries = List.of("moldova", "romania", "usa");
		countries.stream().filter(c -> !Objects.isNull(c))
				.map(c -> c.substring(0,1).toUpperCase(Locale.ROOT) + c.substring(1).toLowerCase(Locale.ROOT))
				.peek(System.out::println)
				.sorted((c1, c2) -> c1.length() - c2.length())
				.collect(Collectors.toList()).stream().forEach(System.out::println);

//		countries.stream().filter(c -> !Objects.isNull(c))
//				.map(c -> c.substring(0,1).toUpperCase(Locale.ROOT) + c.substring(1).toLowerCase(Locale.ROOT))
//				.forEach(System.out::println);
	}
}
