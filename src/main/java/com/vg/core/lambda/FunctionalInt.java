package com.vg.core.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInt {
	public static void main(String[] str) {
		Function<String, String> function = x -> x.toUpperCase(); System.out.println(function.apply("StRaNgE"));
		Supplier<String> supplier = () -> "String1";  System.out.println(supplier.get());
		Consumer<String> consumer = x -> System.out.println(x); consumer.accept("Hello");
		Predicate<Double> predicate = x -> x > 10; System.out.println(predicate.test(15d));
		IntConsumer intConsumer = x -> 	System.out.println(x); intConsumer.accept(5);
		BiFunction<Integer, Integer, Integer> biFunction = (x,y) -> x+y; System.out.println(biFunction.apply(1,2));
		
		Comparator<Integer> comparator = (x,y) -> x>y ? -1 : 1;   System.out.println(comparator.compare(1, 2));
		
		List<String> genre = new ArrayList<String>(Arrays.asList("rock", "pop", "jazz", "reggae"));
		long a = genre.stream().filter(s -> s.startsWith("r")).count();
		System.out.println(a);
		System.out.println(genre.stream().distinct().count());
	}
}
