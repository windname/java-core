
package com.vg.different;

import java.util.ArrayList;
import java.util.List;

public class GenTest {
	public static void main(String[] str) {
		// List<?> list = new ArrayList<Integer>();

		// List<ArrayList<? super Number>> addlist = new ArrayList<ArrayList<?
		// super Number>>();

		// super could be useful if purpose of list is to add elements to it
		List<? super Number> addlist = new ArrayList<Number>();
		addlist.add(new Integer(1));

		// extends is for invocation of Number methods from any object from the
		// list
		// cannot add new elements!!!
		List<? extends Number> showlist = new ArrayList<Integer>();
		// showlist.add((Object)(new Integer(1)));
		for (Object n : showlist) {
			System.out.println("n=" + n);
		}

		final int two = 2;
		List<? extends Number> hucklist = new ArrayList<Integer>() {
			{
				add(two);
			}
		};
		// list.add(new ArrayList<Integer>(1));
		// list.get(0).add(new Integer(1));
		for (Number n : hucklist)
			System.out.println("N=" + n);

		List<?> showlist2 = new ArrayList<Integer>();

	}
}
