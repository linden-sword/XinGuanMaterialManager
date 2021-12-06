package com.zs.xinguanmaterialmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class XinGuanMaterialManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(XinGuanMaterialManagerApplication.class, args);
    }

}
