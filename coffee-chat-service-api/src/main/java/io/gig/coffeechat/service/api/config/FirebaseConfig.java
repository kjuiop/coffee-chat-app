package io.gig.coffeechat.service.api.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import io.gig.coffeechat.service.api.util.properties.FirebaseSdkProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author : JAKE
 * @date : 2022/11/16
 */
@Configuration
@RequiredArgsConstructor
public class FirebaseConfig {

    @Value("${firebase.sdk.path}")
    private String sdkPath;

    private FirebaseApp firebaseApp;

    @PostConstruct
    public FirebaseApp initializeFCM() throws IOException {
        Resource resource = new ClassPathResource(sdkPath);
        FileInputStream fis = new FileInputStream(resource.getFile());
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(fis))
                .build();
        firebaseApp = FirebaseApp.initializeApp(options);
        return firebaseApp;
    }

    @Bean
    public FirebaseAuth initFirebaseAuth() {
        FirebaseAuth instance = FirebaseAuth.getInstance(firebaseApp);
        return instance;
    }
}
