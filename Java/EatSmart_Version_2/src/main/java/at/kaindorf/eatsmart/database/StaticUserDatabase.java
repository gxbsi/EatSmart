package at.kaindorf.eatsmart.database;

import at.kaindorf.eatsmart.pojos.User;

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
        addUserToList();
    }

    public static StaticUserDatabase getInstance()
    {
        if(theInstance == null)
        {
            theInstance = new StaticUserDatabase();
        }
        return theInstance;
    }

    private void addUserToList()
    {
        //Hier wird die Liste mit allen Usern aus der Datenbank befüllt
        User testUser = new User(1l, "Gabriel", "Haikal", 198,
                LocalDate.parse("24.02.2005", DTF), "admin", "admin");
        userList.add(testUser);
        passwords.put("admin", "admin");
    }

    public User login(String username, String passwd){
        String passwdDB = passwords.get(username);
        if(passwdDB != null && passwdDB.equals(passwd)){
            return userList.stream()
                    .filter(user -> user.getUsername().equals(username)).findFirst().get();
        }
        throw new NoSuchElementException("User not found");
    }

}
