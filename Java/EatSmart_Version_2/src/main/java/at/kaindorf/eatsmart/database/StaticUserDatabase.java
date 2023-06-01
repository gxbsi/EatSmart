package at.kaindorf.eatsmart.database;

import at.kaindorf.eatsmart.io.IO_Access;
import at.kaindorf.eatsmart.pojos.User;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class StaticUserDatabase
{

    private static StaticUserDatabase theInstance;
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    private List<User> userList = new ArrayList<>();
    private Map<String, String> passwords = new HashMap<>();

    private StaticUserDatabase()
    {
        try {
            userList.addAll(IO_Access.getUsersFromCsvFile());
            System.out.println(userList);
            for (User user: userList)
            {
                passwords.put(user.getUsername(), user.getPasswort());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static StaticUserDatabase getInstance()
    {
        if(theInstance == null)
        {
            theInstance = new StaticUserDatabase();
        }
        return theInstance;
    }

    public User login(String username, String passwd)
    {
        String passwdDB = passwords.get(username);
        if(passwdDB != null && passwdDB.equals(passwd)){
            return userList.stream()
                    .filter(user -> user.getUsername().equals(username)).findFirst().get();
        }
        throw new NoSuchElementException("User not found");
    }

    public User register(User user)
    {
        if(!userList.contains(user))
        {
            Long id = userList.stream().mapToLong(c -> c.getUserID()).max().getAsLong();
            user.setUserID(id);
            userList.add(user);
            passwords.put(user.getUsername(), user.getPasswort());
            try {
                IO_Access.addUser(userList);
            } catch (URISyntaxException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return user;
        }
        throw new KeyAlreadyExistsException("User schon vorhanden!");
    }

}
