package com.notetakingapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories("com.notetakingapi.repository")
@EnableTransactionManagement
public class DatabaseConfiguration {
}
