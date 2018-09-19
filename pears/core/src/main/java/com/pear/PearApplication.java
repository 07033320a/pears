package com.pear;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com"})
public class PearApplication {

    public static void main(String[] args) {
        SpringApplication.run(PearApplication.class, args);
    }

}
