package at.kaindorf.eatsmart.web;

import at.kaindorf.eatsmart.database.StaticUserDatabase;
import at.kaindorf.eatsmart.pojos.LoginData;
import at.kaindorf.eatsmart.pojos.User;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.NoSuchElementException;

@Path("/login")
public class LoginRessource {
    public static final String JWS_Secret = "EatSmart_ist_eine_sehr_sehr_sehr_gute_SoftwarefuereineSicherERnaehrung";
    private static final StaticUserDatabase userDatabase = StaticUserDatabase.getInstance();

    private String createJWT(String payload) throws JOSEException {
        JWSObject jwsObject = new JWSObject(new JWSHeader(JWSAlgorithm.HS256), new Payload(payload));
        jwsObject.sign(new MACSigner(JWS_Secret.getBytes()));
        return jwsObject.serialize();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(LoginData loginData) {
        try {
            User user = userDatabase.login(loginData.getUsername(), loginData.getPassword());
            String jwtToken = createJWT(user.getUsername());
            return Response.ok().header("Authorization", jwtToken).entity(user).build();
        } catch (NoSuchElementException | JOSEException ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(User user) {
        try {

            return Response.ok().entity(user).build();
        } catch (NoSuchElementException ex) {
            ex.printStackTrace();
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}