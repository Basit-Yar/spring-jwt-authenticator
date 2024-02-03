package com.learning.springjwtauth;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.learning.springjwtauth.repository", mongoTemplateRef = "authMongoTemplate")
public class MongoConfig {

    @Value("${databaseName}")
    private String databaseName;

    @Value("${databaseCluster}")
    private String cluster;

    @Value("${databaseUser}")
    private String databaseUser;

    @Value("${databasePassword}")
    private String databasePassword;

    @Bean(name = "authMongoTemplate")
    @Primary
    public MongoTemplate authMongoTemplate() throws Exception{

        String databaseUrl = "mongodb+srv://" + databaseUser + ":" + databasePassword + "@" + cluster + "/" + databaseName + "?retryWrites=true&w=majority";
        MongoClient client = MongoClients.create(databaseUrl);
        MongoTemplate mongoTemplate =
                new MongoTemplate(client, databaseName);
        return mongoTemplate;
    }
}
