package io.gig.coffeechat.domain.attachment.utils.properties;

import io.gig.coffeechat.domain.util.YamlPropertySourceFactory;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author : JAKE
 * @date : 2022/12/13
 */
@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "aws.s3")
@PropertySource(value="classpath:/application-credentials.yml", factory = YamlPropertySourceFactory.class)
public class S3Properties {
    String endPoint;
    String regionName;
    String bucketName;
    String accessKey;
    String secretKey;
    String prefixUrl;
}