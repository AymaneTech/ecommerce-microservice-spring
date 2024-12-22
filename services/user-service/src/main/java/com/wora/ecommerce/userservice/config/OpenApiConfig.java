package com.wora.ecommerce.userservice.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableConfigurationProperties(OpenApiConfig.OpenApiConfigurationProperties.class)
public class OpenApiConfig {

    @Bean
    public OpenAPI defineOpenApi(OpenApiConfigurationProperties props){
        Server server = new Server();
        server.setUrl(props.server().url());
        server.setDescription(props.server().description());

        Contact contact = new Contact();
        contact.setName(props.info().contact().name());
        contact.setEmail(props.info().contact().email());
        contact.setUrl(props.info().contact().url());

        Info info = new Info()
                .title(props.info().title())
                .version(props.info().version())
                .description(props.info().description())
                .contact(contact);

        return new OpenAPI().info(info).servers(List.of(server));
    }

    @ConfigurationProperties("app.open-api")
    record OpenApiConfigurationProperties(
            Info info,
            Server server
    ) {
        public record Server(
                @DefaultValue("http://localhost:8080")
                String url,

                @DefaultValue("Waiting room management module")
                String description
        ) {
        }

        public record Contact(
                @DefaultValue("Aymane El Maini")
                String name,

                @DefaultValue("elmainiaymane03@gmail.com")
                String email,

                @DefaultValue("https://aymaneelmaini.vercel.app")
                String url
        ) {
        }

        public record Info(
                @DefaultValue("Waiting room management module")
                String title,

                @DefaultValue("1.0.0")
                String version,

                @DefaultValue("Waiting room management module")
                String description,
                Contact contact
        ) {
        }
    }
}
