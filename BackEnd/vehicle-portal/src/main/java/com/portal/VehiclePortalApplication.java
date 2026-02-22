package com.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.portal.controller",
        "com.portal.service",
        "com.portal.repository",
        "com.portal.model",
        "com.portal.config"
})
public class VehiclePortalApplication {

    public static void main(String[] args) {
        SpringApplication.run(VehiclePortalApplication.class, args);
    }
}
