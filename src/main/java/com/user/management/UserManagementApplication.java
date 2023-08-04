package com.user.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
//@ComponentScan(basePackages = { "com.user", "com.user.management.api" , "com.user.management.configuration"})
public class UserManagementApplication {



    public static void main(String[] args) throws Exception {
        new SpringApplication(UserManagementApplication.class).run(args);
    }


}
