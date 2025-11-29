package com.aurum.PrismxMongoDB.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        // 1. Cargamos el archivo .env
        // (directory = "./" asegura que busque en la raíz del proyecto)
        Dotenv dotenv = Dotenv.configure().directory("./").ignoreIfMissing().load();

        // 2. Leemos las variables
        String usuario = dotenv.get("MONGO_USER");
        String password = dotenv.get("MONGO_PASS");
        String cluster = dotenv.get("MONGO_CLUSTER");
        String db = dotenv.get("MONGO_DB");

        // 3. Armamos la cadena de conexión dinámicamente
        String connectionString = String.format(
            "mongodb+srv://%s:%s@%s/%s?retryWrites=true&w=majority&appName=Cluster0",
            usuario, password, cluster, db
        );

        return MongoClients.create(connectionString);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        // Usamos el nombre de la base de datos definido en el .env
        Dotenv dotenv = Dotenv.configure().directory("./").ignoreIfMissing().load();
        return new MongoTemplate(mongoClient(), dotenv.get("MONGO_DB"));
    }
}