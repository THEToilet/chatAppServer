package jp.ac.shibaura.it.ie;

import com.google.inject.Guice;
import com.google.inject.Injector;
import jp.ac.shibaura.it.ie.contorollers.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class Main {
    public static void main(String... args) {
        SpringApplication.run(Main.class, args);
    }
}