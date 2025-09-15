package INAF.LybraSys.Ressource.Domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "ressource")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)

public class Ressource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRessource;
    private String title;
    private String autor;
    private Date date_Publication;
    private String category;
    private String state;

}
