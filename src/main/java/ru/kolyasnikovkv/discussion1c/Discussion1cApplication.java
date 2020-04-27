package ru.kolyasnikovkv.discussion1c;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.flyway.FlywayAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "ru.kolyasnikovkv.discussion1c"
        //,//Disabling Specific Auto-configuration Classes
        //exclude = {DataSourceAutoConfiguration.class, FlywayAutoConfiguration.class}
        )
public class Discussion1cApplication {

    public static void main(String[] args){
        SpringApplication.run(Discussion1cApplication.class, args);
    }

}
