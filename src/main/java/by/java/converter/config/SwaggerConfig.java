package by.java.converter.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Конфигуратор Swagger.
 */
@Configuration
public class SwaggerConfig {

  /**
   * Конструктор для Swagger.
   */
  @Bean
  public OpenAPI api() {
    return new OpenAPI()
        .servers(
          List.of(
            new Server().url("http://localhost:8080")
          )
        ).info(
          new Info().title("Converter for currencies")
        );
  }
}
