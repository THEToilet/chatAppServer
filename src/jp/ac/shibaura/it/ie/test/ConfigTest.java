package jp.ac.shibaura.it.ie.test;

import jp.ac.shibaura.it.ie.config.Config;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

public class ConfigTest {

    @Test
    public void testConfig() throws Exception {
        System.out.println(Config.get().getDBName());
        System.out.println(Config.get().getDBPort());
        System.out.println(Config.get().getDBUrl());
        System.out.println(Config.get().getDBPassword());
        System.out.println(Config.get().getDBUserId());
        assertThat(Config.get().getDBName()).isEqualTo("db_group_a");
        assertThat(Config.get().getDBPort()).isEqualTo("13308");
    }
}
