package ru.riji.t1_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.riji.t1_test.controller.ApiController;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class SmokeTest {
    @Autowired
    private ApiController apiController;

    @Test
    void contextLoads() throws Exception{
        assertThat(apiController).isNotNull();
    }
}
