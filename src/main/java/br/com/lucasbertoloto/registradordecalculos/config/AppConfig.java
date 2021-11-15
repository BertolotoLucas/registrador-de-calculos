package br.com.lucasbertoloto.registradordecalculos.config;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    public @Bean
    MongoClient mongoClient() {

        ConnectionString connectionString = new ConnectionString("mongodb+srv://root:vrbdkd6ZQAZ2rL5K@mongodbaws.myb8v.mongodb.net/admin?retryWrites=true&w=majority");
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();
        MongoClient mongoClient = MongoClients.create(settings);

        return mongoClient;
    }


}
