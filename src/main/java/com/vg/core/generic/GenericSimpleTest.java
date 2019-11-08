
package com.vg.core.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenericSimpleTest {
	public static void main(String[] str) {
	    // wildcard collection
		 List<?> nullList = new ArrayList<Integer>();
		 // allows add only null value for type safety
         nullList.add(null);
         nullList.stream().forEach(System.out::println); // outpult null

        // lower bounding
		List<? super Number> addlist = new ArrayList<Number>();
        // super could be useful if purpose of list is to add elements to it
		addlist.add(new Integer(1));
        // addlist.add(new Object()); // not allows
        addlist.add(new Float(1));
        addlist.stream().forEach(System.out::print); // outpult null

		// extends is for invocation of Number methods from any object from list
		List<? extends Number> showlist = new ArrayList<Integer>();
		// showlist.add(new Integer(1)); // not allowed
        showlist = Arrays.asList(1.2f, 99.9f);

		for (Number n : showlist)
			System.out.println("N=" + n);

	}
}
