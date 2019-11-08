package com.vg.core.copy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author vgrigoriev (vladimir.grigoriev@codefactorygroup.com) 11/8/2019
 */


public class CloneInterface {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Animal> animals = Arrays.asList(new Animal("lion"), new Animal("tiger"));
        Zoo zoo = new Zoo("Md",100, animals);

        System.out.println(zoo);
        // 1. returns same result for deault clone method
        // 2 all reference of anilas are different. This is deep clone
        System.out.println(zoo.clone());
    }
}


class Zoo implements Cloneable{
    String name;
    int size;
    List<Animal> animals;

    public Zoo(String name, int size, List<Animal> animals) {
        this.name = name;
        this.size = size;
        this.animals = animals;
    }

    @Override
    public String toString() {
        return "Zoo:" + name + ":" + size + ":" + animals + ":" + animals.stream().map(a -> a.toString()).collect(Collectors.joining( "," ));
    }

    public Zoo clone() throws CloneNotSupportedException{
        Zoo newZoo = (Zoo)super.clone();
        newZoo.animals =
                this.animals.stream().map(a -> a.clone()).collect(Collectors.toList());
        return newZoo;
    }
}


class Animal implements Cloneable {
    String name;

    public Animal(String name) {
        this.name = name;
    }

    public Animal clone() {
        try {
            return (Animal)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return this;
    }
}
