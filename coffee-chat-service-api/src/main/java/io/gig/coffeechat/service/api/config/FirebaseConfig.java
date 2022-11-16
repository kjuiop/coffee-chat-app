package io.gig.coffeechat.service.api.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

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
        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(getFirebaseInfo()))
                .build();
        firebaseApp = FirebaseApp.initializeApp(options);
        return firebaseApp;
    }

    @Bean
    public FirebaseAuth initFirebaseAuth() {
        FirebaseAuth instance = FirebaseAuth.getInstance(firebaseApp);
        return instance;
    }

    private InputStream getFirebaseInfo() throws IOException {
        Resource resource = new ClassPathResource(sdkPath);
        if (resource.exists()) {
            return resource.getInputStream();
        }
        throw new RuntimeException("firebase 키가 존재하지 않습니다.");
    }
}
