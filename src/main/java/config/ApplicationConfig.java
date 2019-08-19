package config;

/* Java EE 8 API Security : https://rieckpil.de/howto-simple-form-based-authentication-for-jsf-2-3-with-java-ee-8-security-api/
@CustomFormAuthenticationMechanismDefinition(
    loginToContinue = @LoginToContinue (
        loginPage = "/login.xhtml",
        useForwardToLogin = false
    )
)
*/

import javax.enterprise.context.ApplicationScoped;
import javax.faces.annotation.FacesConfig;

@FacesConfig
@ApplicationScoped
public class ApplicationConfig {

}
