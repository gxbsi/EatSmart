package at.kaindorf.eatsmart.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User
{
    private Long userID;
    private String firstname;
    private String lastname;
    private Integer groesse;
    private LocalDate geurtsdatum;
    private String username;
    private String passwort;
}
