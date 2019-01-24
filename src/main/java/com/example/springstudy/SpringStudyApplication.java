package com.example.springstudy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
public class SpringStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringStudyApplication.class, args);
    }

/*    @PostConstruct
    public void initApplication(){
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }*/
    /*@PostConstruct
    public void initApplication(){
        UserEntity user = UserEntity.builder().name("박춘소").email("chunso@email.com").build();

    }*/
}

