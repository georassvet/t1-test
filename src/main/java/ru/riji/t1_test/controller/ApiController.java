package ru.riji.t1_test.controller;

import jdk.jshell.execution.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.riji.t1_test.service.StringService;
import ru.riji.t1_test.service.Utils;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class ApiController {
    @Autowired
    private StringService stringService;

    @GetMapping(value = "/parse/{str}")
    public ResponseEntity<?> parseString(@PathVariable("str") String str, @RequestParam(name = "sort", required = false) String sort){
        Map<Character, Integer> map = stringService.countCharactersInStr(str);
        Comparator<Integer> comparator = Comparator.naturalOrder();
        if(sort !=null && sort.equals("desc")){
            comparator = Comparator.reverseOrder();
        }



        return new ResponseEntity<>(Utils.sortMapByValue(map, comparator), HttpStatus.OK);
    }
}
