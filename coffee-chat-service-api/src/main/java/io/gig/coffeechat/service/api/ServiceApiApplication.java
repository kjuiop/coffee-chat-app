package io.gig.coffeechat.service.api;

import io.gig.coffeechat.domain.config.ComponentConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Import(ComponentConfig.class)
@EnableDiscoveryClient
@SpringBootApplication
public class ServiceApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceApiApplication.class, args);
    }

}
