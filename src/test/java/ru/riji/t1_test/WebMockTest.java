package ru.riji.t1_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import ru.riji.t1_test.controller.ApiController;
import ru.riji.t1_test.service.StringService;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ApiController.class)
public class WebMockTest {
    @Autowired
    private MockMvc mockMvc;

    private static String inputString = "aaabbcccc";
    private static final Map<Character, Integer> outputMap = new HashMap<>();

    static {
        outputMap.put('a', 3);
        outputMap.put('b', 2);
        outputMap.put('c', 4);
    }


    @MockBean
    private StringService stringService;

    @Test
    void testEntryPoint() throws Exception {
        when(stringService.countCharactersInStr(inputString)).thenReturn(outputMap);

        this.mockMvc.perform(get("/parse/"+inputString)).andDo(print())
                .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"a\":")));
    }

}
