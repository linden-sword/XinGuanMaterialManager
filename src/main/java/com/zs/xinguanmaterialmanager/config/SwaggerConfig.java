package com.zs.xinguanmaterialmanager.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;


@Configuration
public class SwaggerConfig {
    @Bean
    public Docket   getDocket(){
        return  new Docket(DocumentationType.OAS_30).apiInfo(getApiInfo());
        /*return  new Docket(DocumentationType.OAS_30)
                .apiInfo(getApiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .paths(PathSelectors.any())
                .build();*/
    }

    @Bean
    public ApiInfo   getApiInfo(){
        return   new ApiInfoBuilder()
                .title("客户关系管理系统-接口文档")
                .description("这是华杉的crm！！！！")
                .contact(new Contact("*****","url","email"))
                .version("v1.0")
                .build();
    }
}
