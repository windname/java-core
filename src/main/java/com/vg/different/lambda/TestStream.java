package com.vg.different.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestStream {
	public static void main(String[] str) {
		List<String> list = new ArrayList<String>() {
			{
				add("One");
				add("Two");
				add("Three");
			}
		};

		list.stream().map(String::toUpperCase).forEach(System.out::println);

		List<String> shortNumber = list.stream().filter(name -> name.length() < 4).collect(Collectors.toList());
		shortNumber.forEach(System.out::println);

	}
}
