package com.nexsys.crud.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "API NEXSYS",
                description = "Documentacion de servicios",
                version = "1.0.0",
                contact = @Contact(
                        name = "Carlos Tafur",
                        url = "https://www.linkedin.com/in/carlosalbertotafur/"
                ),
                license = @License(
                        name = "Standard Software Use License"
                )
        ),
        servers = {
                @Server(
                        description = "DEV SERVER",
                        url = "http://localhost:8080/nexsys"
                ),
                @Server(
                        description = "DEV RENDER SERVER",
                        url = "https://backendnexsys.onrender.com/nexsys"
                )
        }
)
public class SwaggerConfig {
}
