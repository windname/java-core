package com.vg.different.lambda;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Supplier;

public class RefMethod {
	public static void main(String[] args) {
		String[] animals = new String[]{"lion", "hipo", "elephant"};
		
		// Arbitrary Object ref method
		Arrays.sort(animals, String::compareToIgnoreCase);
		System.out.println(Arrays.asList(animals));
		
		// static usage of reference method
		Arrays.sort(animals, RefMethod::compareLength);
		System.out.println(Arrays.asList(animals));
		
		// particular object ref method
		Arrays.sort(animals, new RefMethod()::inverseSort);
		System.out.println(Arrays.asList(animals));
		
		Function<String, Integer> strLength = s -> s.length();
		System.out.println(strLength.apply("Hello"));
		
		// constructor ref method (returns suplier value!)
		showString(String::new);
		showString(() -> "String2");
		
	}
	
	private int inverseSort(String a1, String a2) {
		return a2.compareTo(a1);
	}
	
	private static int compareLength(String a1, String a2) {
		return new Integer(a1.length()).compareTo(a2.length());
	}
	
	private static void showString(Supplier<String> strSup) {
		System.out.println("Str=" + strSup.get());
	}
}
