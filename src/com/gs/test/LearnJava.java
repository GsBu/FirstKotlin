package com.gs.test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.*;

public class LearnJava {
    public static void main(String[] args){
        String words = "Hello, World";
        String lowerWords = changeWords(words, String::toLowerCase);
        System.out.println(lowerWords);

        String upperWords = changeWords(words, String::toUpperCase);
        System.out.println(upperWords);

        int count = wordsToInt(words, String::length);
        wordsToInt(words, new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        });
        System.out.println(count);

        isSatisfy(words, w -> w.contains("Hello"));
        isSatisfy(words, new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.contains("hello");
            }
        });

        String otherWords = appendWords(words, () -> {
            List<String> allWords = Arrays.asList("+abc", "->efg");
            return allWords.get(new Random().nextInt(2));
        });
        System.out.println(otherWords);
        consumeWords(words, w -> System.out.println(w.split(",")[0]));
        consumeWords(words, new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s.split(",")[1]);
            }
        });
    }

    public static String changeWords(String words, UnaryOperator<String> func) {
        return func.apply(words);
    }

    public static int wordsToInt(String words, Function<String, Integer> func) {
        return func.apply(words);
    }

    public static void isSatisfy(String words, Predicate<String> func) {
        if (func.test(words)) {
            System.out.println("test pass");
        } else {
            System.out.println("test failed.");
        }
    }

    public static String appendWords(String words, Supplier<String> func) {
        return words + func.get();
    }

    public static void consumeWords(String words, Consumer<String> func) {
        func.accept(words);
    }

    @FunctionalInterface
    interface MyFunctionalInterface{

        void get();

        default void set(){

        }
    }
}
