package org.Bank;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"org.Bank.repo"})
@EnableAutoConfiguration
public class App 
{
	
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
        System.out.println("run");
    }
}