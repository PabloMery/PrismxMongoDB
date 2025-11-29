package com.aurum.PrismxMongoDB.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    // Tu cadena de conexión Hardcoded (La que SÍ funciona)
    private static final String CONNECTION_STRING = "mongodb+srv://PabloMery:12345@cluster0.2qo3nwl.mongodb.net/teleton_db?retryWrites=true&w=majority&appName=Cluster0";

    @Bean
    public MongoClient mongoClient() {
        return MongoClients.create(CONNECTION_STRING);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "teleton_db");
    }
}