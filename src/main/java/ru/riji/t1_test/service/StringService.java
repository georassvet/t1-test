package ru.riji.t1_test.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class StringService {
    public Map<Character, Integer> countCharactersInStr(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char element = str.charAt(i);
            Integer counter = map.get(element);
            map.put(element, counter==null ? 1 : ++counter);
        }
        return map;
    }
}
