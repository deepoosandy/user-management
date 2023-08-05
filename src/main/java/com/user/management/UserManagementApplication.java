package com.user.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@SpringBootApplication
@EnableOpenApi
public class UserManagementApplication {
    public static void main(String[] args) throws Exception {
        new SpringApplication(UserManagementApplication.class).run(args);
    }


}
