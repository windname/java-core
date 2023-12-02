package com.vg.certif.collection;

import java.util.*;
import java.util.stream.Collectors;

public class SortCollections {
    public static void main(String[] args) {

        Integer[] arr = {2,8,3,5}; // Array of wrapper integer
        HashSet set = new HashSet(Arrays.asList(arr));
        System.out.println(set);

        // Collections sort
        List list = Arrays.asList(arr);
        Collections.sort(list , (Integer a, Integer b) -> Integer.compare(a,b));
        System.out.println(list);
        List compList = Arrays.stream(arr).sorted((o1,o2) -> o1 - o2).collect(Collectors.toList());
        System.out.println("comparator list " + compList);
        List sList = Arrays.stream(arr).sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        System.out.println("Natural order " + sList);
        Arrays.stream(arr).forEachOrdered(e -> System.out.print(" " + e));

    }
}
