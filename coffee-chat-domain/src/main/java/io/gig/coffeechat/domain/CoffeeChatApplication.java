package io.gig.coffeechat.domain;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@SpringBootApplication
public class CoffeeChatApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(CoffeeChatApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
    }

}
