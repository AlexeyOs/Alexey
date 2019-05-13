package ru.osetsky.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.osetsky.storage.StorageProperties;
import ru.osetsky.storage.StorageService;

@Configuration
@EnableConfigurationProperties(StorageProperties.class)
@ComponentScan("ru.osetsky")
public class SpringRootConfig {

    @Bean
    CommandLineRunner init(StorageService storageService) {
//        System.getProperties().put( "spring.servlet.multipart.max-file-size", "128KB");
//        System.getProperties().put( "spring.servlet.multipart.max-request-size", "128KB");
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }
}
