package com.aurum.PrismxMongoDB.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    private static final Logger log = LoggerFactory.getLogger(MongoConfig.class);

    @Bean
    public MongoClient mongoClient() {
        // Apuntamos directo a la subcarpeta donde tienes el archivo
        String directorioProyecto = System.getProperty("user.dir") + "/PrismxMongoDB";
        
        log.info("🔍 Buscando configuración en: {}", directorioProyecto);

        Dotenv dotenv = Dotenv.configure()
                .directory(directorioProyecto) 
                .ignoreIfMissing()
                .load();

        String connectionString = String.format(
            "mongodb+srv://%s:%s@%s/%s?retryWrites=true&w=majority&appName=Cluster0",
            dotenv.get("MONGO_USER"),
            dotenv.get("MONGO_PASS"),
            dotenv.get("MONGO_CLUSTER"),
            dotenv.get("MONGO_DB")
        );

        log.info("✅ Conectando a MongoDB Atlas...");
        return MongoClients.create(connectionString);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        String directorioProyecto = System.getProperty("user.dir") + "/PrismxMongoDB";
        Dotenv dotenv = Dotenv.configure().directory(directorioProyecto).ignoreIfMissing().load();
        
        String dbName = dotenv.get("MONGO_DB");
        if (dbName == null) dbName = "test";
        
        return new MongoTemplate(mongoClient(), dbName);
    }
}