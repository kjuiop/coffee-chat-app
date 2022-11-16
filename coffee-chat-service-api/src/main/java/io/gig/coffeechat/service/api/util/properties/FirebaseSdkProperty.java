package io.gig.coffeechat.service.api.util.properties;

import io.gig.coffeechat.service.api.util.YamlPropertySourceFactory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author : JAKE
 * @date : 2022/11/16
 */
@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "firebase.sdk.path")
@PropertySource(value="classpath:/application.yml", factory = YamlPropertySourceFactory.class)
public class FirebaseSdkProperty {
    String path;
}
