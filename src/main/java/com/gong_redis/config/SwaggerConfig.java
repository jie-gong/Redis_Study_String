package com.gong_redis.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * @author:
 * @Project: JavaLaity
 * @Pcakage: com.gong_redis.config.SwaggerConfig
 * @Date: 2022年10月05日 11:21
 * @Description:
 */
@Configuration
@EnableSwagger2//开启Swagger2
public class SwaggerConfig {

//    @Value(value = "ture")
//    private Boolean swaggerEnabled;

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
//                .enable(swaggerEnabled)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.gong_redis"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口文档")
                .description("小杰杰爱编程")
                .termsOfServiceUrl("#")
                .version("1.0")
                .build();
    }


}
