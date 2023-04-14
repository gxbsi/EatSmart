package at.kaindorf.eatsmart.pojos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Adresse
{
    private Long adressID;
    private String land;
    private String strasse;
    private String hausnummer;
    private Integer plz;
    private String ort;
}
