package INAF.LybraSys.Exemplaire.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "exemplaire")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class Exemplaire {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id_Exemplaire;

    @ManyToOne
    @JoinColumn(name = "ressource_id")
    private Exemplaire exemplaire;
}
