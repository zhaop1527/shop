package com.baili.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class swaggerConfig {

    @Bean
    public Docket createDocket(){
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(createApiInfo())
                .groupName("zhao")
                .enable(true)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.baili.controller"))
                .build();
    }

    public ApiInfo createApiInfo(){
        return new ApiInfoBuilder()
                .title("测试标题")
                .description("测试描述")
                .termsOfServiceUrl("http://www.baidu.com")
                .build();
    }
}
