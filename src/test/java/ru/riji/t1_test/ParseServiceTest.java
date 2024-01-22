package ru.riji.t1_test;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.riji.t1_test.service.StringService;
import ru.riji.t1_test.service.Utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.hamcrest.Matchers.hasEntry;


@SpringBootTest
public class ParseServiceTest {
    private static String inputString = "aaabbcccc";
    private static final Map<Character, Integer> outputMap = new HashMap<>();
    private static final Map<Character, Integer> sortedMap = new LinkedHashMap<>();

    static {
        outputMap.put('b', 2);
        outputMap.put('a', 3);
        outputMap.put('c', 4);

        sortedMap.put('c', 4);
        sortedMap.put('a', 3);
        sortedMap.put('b', 2);
    }
    @Autowired
    private StringService parseService;

    @Test
    public  void testCountCharactersInStr(){

        Map<Character,Integer> map = parseService.countCharactersInStr(inputString);

        assertThat(map).isNotEmpty().hasSize(3);
        assertThat(map).containsAllEntriesOf(outputMap);
    }

    @Test
    public  void testReverseSortMap(){

        Map<Character, Integer> afterSort = Utils.sortMapByValue(outputMap, Comparator.reverseOrder());
        assertThat(afterSort).containsExactlyEntriesOf(sortedMap);
    }
}
