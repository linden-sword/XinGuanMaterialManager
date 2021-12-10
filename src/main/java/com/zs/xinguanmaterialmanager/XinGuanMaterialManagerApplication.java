package com.zs.xinguanmaterialmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class XinGuanMaterialManagerApplication {
    public static void main(String[] args) {
//        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow","{}[]| ");
        SpringApplication.run(XinGuanMaterialManagerApplication.class, args);
    }
}
