package io.gig.coffeechat.domain.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * @author : JAKE
 * @date : 2022/11/09
 */
@Configuration
@ComponentScan(basePackages ="io.gig.coffeechat.domain")
@EntityScan(basePackages = "io.gig.coffeechat.domain")
@EnableJpaRepositories(basePackages = "io.gig.coffeechat.domain")
public class ComponentConfig {
}
