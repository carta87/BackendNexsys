/*package com.nexsys.crud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/v1/products/**") // O cualquier otro endpoint que necesites
                .allowedOrigins("https://backendnexsys.onrender.com/") // Cambia esto a tu front-end
                .allowedMethods("GET", "POST") // Métodos permitidos
                .allowedHeaders("*") // Permitir todos los encabezados
                .allowCredentials(true);
    }
}
*/