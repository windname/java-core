package com.vg.core.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;

public class ReduceAndCollect {

	public static void main(String[] str) {
		List<Person> persons = new ArrayList<Person>();
		persons.add(new Person(25, "Monika", Sex.Female));
		persons.add(new Person(35, "Jesica", Sex.Female));
		persons.add(new Person(31, "Tom", Sex.Male));
		
		// simple reduce operations 
		double average = persons.stream().filter(p -> p.getGender() == Sex.Female).mapToInt(Person::getAge).average().getAsDouble();
		System.out.println("Average femail age is " + average);

		// explicit reduce operation
		// sum of ages
		Integer totalAgeReduce = persons.stream().map(Person::getAge).reduce(0,(a, b) -> a + b);
		System.out.println("Sum persons age is " + totalAgeReduce);
		
		Averager averageCollect = persons.stream().map(p->p.getAge()).collect(Averager::new, Averager::accept, Averager::combine);
		System.out.println("Avergae age is " + averageCollect.average());
		
		Map<Sex, List<Person>> byGender = persons.stream().collect(Collectors.groupingBy(Person::getGender));
		
		Map<Sex, List<String>> namesByGender =
				persons.stream().collect(Collectors.groupingBy(Person::getGender,Collectors.mapping(Person::getName,Collectors.toList()))); 
		System.out.println("girls " + namesByGender.get(Sex.Female));
		
		// age sum by gender
		Map<Sex, Integer> totalAgeByGender = persons.stream().collect(Collectors.groupingBy(Person::getGender, Collectors.reducing(0, Person::getAge, Integer::sum)));
		System.out.println("sum age by gender " + totalAgeByGender);
		
		// 9. Average age by gender
        Map<Sex, Double> averageAgeByGender =
        		persons.stream().collect(Collectors.groupingBy(Person::getGender,Collectors.averagingInt(Person::getAge)));
        System.out.println("avergae age by gender " + averageAgeByGender);
		

	}

}

class Averager implements IntConsumer
{
	private int total = 0;
    private int count = 0;

	@Override
	public void accept(int value) {
		total+=value; count++;
	}
	
	public double average() {
        return count > 0 ? ((double) total)/count : 0;
    }
        
    public void combine(Averager other) {
        total += other.total;
        count += other.count;
    }
}

enum Sex {
	Male, Female;
}

class Person {

	public Person(int age, String name, Sex gender) {
		super();
		this.age = age;
		this.name = name;
		this.setGender(gender);
	}

	private int age;
	private String name;
	private Sex gender;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Sex getGender() {
		return gender;
	}

	public void setGender(Sex gender) {
		this.gender = gender;
	}

}
