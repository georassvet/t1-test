package ru.riji.t1_test.service;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Utils {
    public static Map<Character, Integer>  sortMapByValue(Map<Character, Integer> map, Comparator<Integer> comparator){
       return map.entrySet().stream().sorted(Map.Entry.comparingByValue(comparator)).collect(Collectors.toMap(x->x.getKey(), x->x.getValue(),
                (e1, e2) -> e1, LinkedHashMap::new));
    }
}
