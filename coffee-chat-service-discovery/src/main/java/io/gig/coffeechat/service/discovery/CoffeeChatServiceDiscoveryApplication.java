package io.gig.coffeechat.service.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author : JAKE
 * @date : 2022/12/10
 */
@EnableEurekaServer
@SpringBootApplication
public class CoffeeChatServiceDiscoveryApplication {
    public static void main(String[] args) {
        SpringApplication.run(CoffeeChatServiceDiscoveryApplication.class, args);
    }
}
