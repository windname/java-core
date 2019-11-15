package com.vg.core.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestForEach {
	public static void main(String[] str) {
		List<String> list = new ArrayList<String>() {
			{
				add("One");
				add("Two");
				add("Three");
			}
		};

		/**
		 * method forEach expects inner class Consumer but it's possible to
		 * replace it with lambda
		 */
		list.forEach((String name) -> System.out.println("number is " + name));

		list.forEach(name -> System.out.println("number is " + name));

		/**
		 * use reference to method
		 */
		list.forEach(System.out::println);

		// add elements to a list
		List<String> upperCaseList = new ArrayList<String>();
		list.forEach(name -> upperCaseList.add(name.toUpperCase()));
		upperCaseList.forEach(System.out::println);
		
		List<String> upperCaseList3 = new ArrayList<String>();
		list.forEach(upperCaseList::add);
		upperCaseList.forEach(System.out::println);
		
		// other option it to create a new list and append to an existing
		List<String> upperCaseList2 = list.stream().map(name -> name.toUpperCase()).collect(Collectors.toList());
		upperCaseList2.forEach(System.out::println);
	}
}
