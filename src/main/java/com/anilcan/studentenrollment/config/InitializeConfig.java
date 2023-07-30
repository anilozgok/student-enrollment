package com.anilcan.studentenrollment.config;

import com.anilcan.studentenrollment.utils.database.DatabaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class InitializeConfig {
    private final DatabaseService dbService;

    @Bean
    public void initDb(){
        dbService.initialize();
    }

}
