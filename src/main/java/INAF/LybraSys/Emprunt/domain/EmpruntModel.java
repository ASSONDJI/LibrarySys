package INAF.LybraSys.Emprunt.domain;


import INAF.LybraSys.Exemplaire.domain.Exemplaire;
import INAF.LybraSys.User.Domain.UsersModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "emprunt")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class EmpruntModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEmprunt;
    private LocalDate datePublication;
    private LocalDate dateRetourEffectif;
    private Double penaliteEventuelle;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersModel user;

    @ManyToOne
    @JoinColumn(name = "exemplaire_id")
    private Exemplaire exemplaire;
}
