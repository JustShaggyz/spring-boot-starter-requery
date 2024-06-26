package bg.codexio.springframework.boot;

import bg.codexio.springframework.data.jpa.requery.config.SwaggerConfig;
import org.springdoc.core.customizers.OperationCustomizer;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass(name = "org.springdoc.core.customizers.OperationCustomizer")
public class SwaggerAutoConfiguration {
    @Bean
    public SwaggerConfig swaggerConfig() {
        return new SwaggerConfig();
    }

    @Bean
    public OperationCustomizer customizeFiltering(SwaggerConfig swaggerConfig) {
        return swaggerConfig.customizeFiltering();
    }

    @Bean
    public OperationCustomizer customizePageable(SwaggerConfig swaggerConfig) {
        return swaggerConfig.customizePageable();
    }
}