package org.dataStructure.array.streamsProblem;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TwoStringAnagramWithStream {
    public static void main(String[] args) {

        //Problem : Find Two string as anagram using stream api
        String str1 = "sekhra";
        String str2 ="rakesh";

        //create character frequency map and compare
        boolean isAnaramMatching = str1.chars()
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .equals(str2.chars().mapToObj(s->(char)s).
                        collect(Collectors.groupingBy(Function.identity(),Collectors.counting())));
        System.out.println(isAnaramMatching ? "Anagram String":"Not Anagram String");

        //sort the String and then comapre
        boolean isAnagram = str1.chars()
                .sorted()
                .boxed()
                .toList()
                .equals(str2.chars().sorted().boxed().toList());
        System.out.println(isAnagram ?"Anagram":"Not Anagram");

        //Concat both String + character frequency Map
        Character c1 = IntStream.concat(str1.chars(),str2.chars())
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
                .entrySet()
                .stream()
                .filter(i->i.getValue()%2!=0)
                .map(k->k.getKey())
                .findAny().orElse(null);
        if(c1 ==null){
            System.out.println("anagram");
        }else{
            System.out.println(" not anagram");
        }
    }
}
