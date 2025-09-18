package INAF.LybraSys.Exemplaire.domain;

import INAF.LybraSys.Ressource.Domain.RessourceModel;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "exemplaire")
public class ExemplaireModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idExemplaire;

    private String codeExemplaire;
    private String etat;
    private String statut;
    private String titre;

    @ManyToOne
    @JoinColumn(name = "ressource_id", nullable = false)
    private RessourceModel ressource;
}
