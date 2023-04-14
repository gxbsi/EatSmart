package at.kaindorf.eatsmart.jwt;

import at.kaindorf.eatsmart.web.LoginRessource;
import com.nimbusds.jose.JOSEException;
import com.nimbusds.jose.JWSObject;
import com.nimbusds.jose.crypto.MACVerifier;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;
import java.text.ParseException;

@JWTNeeded
@Provider
@Priority(Priorities.AUTHORIZATION)
public class JWTNeededFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext crc) throws IOException {
        String token = crc.getHeaderString(HttpHeaders.AUTHORIZATION);
        token = token.replace("Bearer", "");
        try {
            JWSObject jwsObject = JWSObject.parse(token);
            boolean verified = jwsObject.verify(new MACVerifier(LoginRessource.JWS_Secret));
            if(verified){
                crc.setProperty("username", jwsObject.getPayload().toString());
            }else{
                throw new RuntimeException("not verified");
            }
        }catch (ParseException | JOSEException e){
            crc.abortWith(Response.status(Response.Status.UNAUTHORIZED).entity(e).build());
        }
    }
}