package org.acko.smartlife.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.servlet.ServletContext;
import java.util.ArrayList;

/**
 * @author prabodh.hend
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Autowired
    ServletContext servletContext;

    @Value("${swagger.base.url:localhost:8080}")
    String baseUrl;

    @Value("${server.contextPath}")
    String contextPath;

    @Bean
    public Docket productApi() {
        ArrayList<Parameter> parameters = new ArrayList<>();

        return new Docket(DocumentationType.SWAGGER_2)
                .pathProvider(new RelativePathProvider(servletContext) {
                    @Override
                    public String getApplicationBasePath() {
                        return contextPath;
                    }
                })
                .select()
                .apis(RequestHandlerSelectors.basePackage("org.acko.smartlife.controller"))
                .build()
                .globalOperationParameters(parameters)
                .apiInfo(metaData()).ignoredParameterTypes(ApiIgnore.class);
    }

    private ApiInfo metaData() {
        String description = "Acko User Service API";
        return new ApiInfoBuilder()
                .title("Acko User Service REST API")
                .description(description)
                .version("0.0.1")
                .build();
    }

    private Parameter generateParameter(String headerName) {
        return new ParameterBuilder().name(headerName).modelRef(new ModelRef("String")).parameterType("header")
                .required(true)
                .build();
    }
}
