package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return x-> {
            for (String s : x) {
                if (!Character.isUpperCase(s.charAt(0))){
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return x -> {
            int size = x.size();
            for (int i = 0; i < size; i++) {
                int value = x.get(i);
                if (value % 2 == 0) {
                    x.add(value);
                }
            }
            System.out.println(x);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        return () -> {
            List<String> list = new ArrayList<>();
            for (String s : values) {
                String[] words = s.split(" ");
                if (Character.isUpperCase(s.charAt(0)) & s.charAt(s.length()-1) == '.' & words.length > 3){
                    list.add(s);
                }
            }
            return list;
        };
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return x -> {
            Map<String, Integer> map = new HashMap<>();
            for (String s : x) {
                map.put(s, s.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList()  {
        return (list1, list2) -> {
            List<Integer> newList = new ArrayList<>(list1);
            newList.addAll(list2);
            return newList;
        };

    }
}
