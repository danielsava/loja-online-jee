package security;

import javax.enterprise.context.ApplicationScoped;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.security.enterprise.identitystore.CredentialValidationResult;
import javax.security.enterprise.identitystore.IdentityStore;
import java.util.Collections;
import java.util.HashSet;

@ApplicationScoped
public class CustomInMemoryIdentityStore implements IdentityStore {


    @Override
    public CredentialValidationResult validate(Credential credential) {

        UsernamePasswordCredential login = (UsernamePasswordCredential) credential;

        if(login.getCaller().equals("admin@mail.com") && login.getPasswordAsString().equals("ADMIN1234")) {
            return new CredentialValidationResult("admin", new HashSet<>(Collections.singletonList("ADMIN")));
        } else if (login.getCaller().equals("user@mail.com") && login.getPasswordAsString().equals("USER1234")) {
            return new CredentialValidationResult("user", new HashSet<>(Collections.singletonList("USER")));
        } else {
            return CredentialValidationResult.NOT_VALIDATED_RESULT;
        }

    }


}
