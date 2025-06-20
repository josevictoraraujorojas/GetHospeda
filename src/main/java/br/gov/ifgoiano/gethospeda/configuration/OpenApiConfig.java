package br.gov.ifgoiano.gethospeda.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API GetHospeda")
                        .version("v1")
                        .description("API sobre o gerenciamento de hospedagem")
                        .termsOfService("https://ifgoiano.urt.gov/projetos")
                        .license(
                                new License()
                                        .name("Apache 2.0")
                                        .url("https://ifgoiano.urt.gov/projetos")
                        )
                );
    }
}