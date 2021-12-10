package com.zs.xinguanmaterialmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.oas.annotations.EnableOpenApi;


@SpringBootApplication
@ServletComponentScan
@EnableOpenApi
@EnableTransactionManagement
public class XinGuanMaterialManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(XinGuanMaterialManagerApplication.class, args);
    }

}
