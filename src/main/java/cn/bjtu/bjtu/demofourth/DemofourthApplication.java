package cn.bjtu.bjtu.demofourth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableMongoAuditing
@EnableReactiveMongoRepositories
public class DemofourthApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemofourthApplication.class, args);
    }

}
