package com.serviceusers;

import com.serviceusers.entities.Role;
import com.serviceusers.entities.User;
import com.serviceusers.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

import java.util.stream.Stream;

@EnableDiscoveryClient
@SpringBootApplication
public class ServiceUtilisateurApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceUtilisateurApplication.class, args);
    }



}
