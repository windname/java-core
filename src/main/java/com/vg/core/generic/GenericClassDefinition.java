package com.vg.core.generic;

/**
 * @author vgrigoriev (vladimir.grigoriev@codefactorygroup.com) 11/8/2019
 */


public class GenericClassDefinition {
    public static void main(String[] args) {
        Entry<String, String> grade = new Entry<String, String>("Mike", "A");
        Entry<String, Integer> mark = new Entry<String, Integer>("Mike", 100);
        System.out.println("grade: " + grade);
        System.out.println("mark: " + mark);

        Entry<Boolean, Integer> prime = new Entry<Boolean, Integer>(true, 13);
        if (prime.getKey()) System.out.println(prime.getValue() + " is prime.");

        Entry<String, String> strEntry = twice("String");
        System.out.println(strEntry.getKey() + " " + strEntry.getValue());
    }

    public static <Type> Entry<Type, Type> twice(Type value) {
        return new Entry(value, value);
    }
}

class Entry<KeyType, ValueType> {

    private final KeyType key;
    private final ValueType value;

    public Entry(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }

    public KeyType getKey() {
        return key;
    }

    public ValueType getValue() {
        return value;
    }

    public String toString() {
        return "(" + key + ", " + value + ")";
    }

}


