package com.vg.different.lambda;

public class InnerMethod {

	interface Names {
		public void sayName(String name);
	}

	public static void main(String[] args) {
		myName(n -> System.out.println("My name is " + n), "John");
	}

	private static void myName(Names nameInstance, String name) {
		nameInstance.sayName(name);
	}

}
