package cn.hulingfeng.ylzdemo.utils;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger配置文件
 * @author hlf
 * @title: SwaggerConfig
 * @projectName ylzDemo
 * @description: TODO
 * @date 2019/12/2 11:13
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 文档内容创建
     * @return
     */
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo())
                .forCodeGeneration(true)
                .select()
                //接口文档接口选择器
//                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
                .apis(RequestHandlerSelectors.any())
                //接口文档路径选择器
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build()
//                .globalOperationParameters()
                //全局统一token
                .securitySchemes(securitySchemes())
                .securityContexts(securityContexts());
                //全局参数设置,为每个接口添加参数
//                .globalOperationParameters(globalOperationParameters());
    }

    /**
     * 文档信息
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("ylz项目api文档")
                .description("新员工入职项目api文档")
                .termsOfServiceUrl("/")
                .version("1.3")
                .build();
    }

    /**
     * securitySchemes
     * @return
     */
    private List<ApiKey> securitySchemes() {
        return new ArrayList<ApiKey>(){
            {add(new ApiKey("Authorization","Authorization","header"));}
        };
    }

    /**
     * securityContexts
     * @return
     */
    private List<SecurityContext> securityContexts() {
        List<SecurityContext> securityContexts = new ArrayList<>();
        securityContexts.add(
                SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("^(?!auth).*$"))
                .build());
        return securityContexts;
    }

    /**
     * 设置该header应用位置
     * @return
     */
    List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return new ArrayList<SecurityReference>(){
            {add(new SecurityReference("Authorization",authorizationScopes));}
        };
    }

    /**
     * 全局接口参数添加
     * @return
     */
    private List<Parameter> globalOperationParameters(){
        ParameterBuilder tokenParam = new ParameterBuilder();
        List<Parameter> parameters = new ArrayList<>();
        tokenParam
                //传参token
                .name("Authorization")
                //描述
                .description("AuthToken")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build();
        parameters.add(tokenParam.build());
        return parameters;
    }
}
