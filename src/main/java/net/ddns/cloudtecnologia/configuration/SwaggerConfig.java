package net.ddns.cloudtecnologia.configuration;

import javax.ws.rs.core.Application;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "API-Endereço",
                version = "1.0.0",
                contact = @Contact(
                        name = "Thiago junior",
                        url = "www.linkedin.com/in/thiago-melo-84246a149",
                        email = "thi4go19@gmail.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "https://www.apache.org/licenses/LICENSE-2.0.html"
                )
        )
)

public class SwaggerConfig extends Application {
}
