package jp.ac.shibaura.it.ie.test;


import jp.ac.shibaura.it.ie.config.Config;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class HttpLobbyTest {
    @Test
    public void testO(){
        assertThat("dfs").isEqualTo("13308");
    }

}
