package INAF.LybraSys.Ressource.Domain;

import INAF.LybraSys.Exemplaire.domain.ExemplaireModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "ressource")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class RessourceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRessource;

    private String titre;

    private String auteur;

    private String type;

    @OneToMany(mappedBy = "ressource", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ExemplaireModel> exemplaires;


}
