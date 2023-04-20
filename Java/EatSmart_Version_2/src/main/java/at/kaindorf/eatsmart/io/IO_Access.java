package at.kaindorf.eatsmart.io;

import at.kaindorf.eatsmart.pojos.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.IOException;
import java.net.URL;
import java.util.List;

public class IO_Access
{
    public static List<User> getUsersFromCsvFile() throws IOException
    {
        ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);
        URL url = IO_Access.class.getClassLoader().getResource("user.json");
        List<User> user = mapper.readValue(url, new TypeReference<List<User>>() {});
        return user;
    }
}
