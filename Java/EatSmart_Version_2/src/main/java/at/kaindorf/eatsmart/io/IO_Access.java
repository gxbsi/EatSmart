package at.kaindorf.eatsmart.io;

import at.kaindorf.eatsmart.pojos.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
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
    public static void addUser(List<User> user) throws URISyntaxException, IOException {
        URL url = IO_Access.class.getClassLoader().getResource("test.json");
        File file = Paths.get(url.toURI()).toFile();
        System.out.println(url);
        JsonMapper jsonMapper = new JsonMapper();
        jsonMapper.registerModule(new JavaTimeModule());
        jsonMapper.writerWithDefaultPrettyPrinter().writeValue(file, user);
    }

    public static void main(String[] args) throws URISyntaxException, IOException {
        User user = new User(5000l, "test", "test", 195, LocalDate.now(), "testuser", "test");

        addUser(getUsersFromCsvFile());
    }
}


