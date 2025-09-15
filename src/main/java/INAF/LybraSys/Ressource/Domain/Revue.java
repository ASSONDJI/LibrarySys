package INAF.LybraSys.Ressource.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.NamedEntityGraph;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "revue")
@AllArgsConstructor
@NamedEntityGraph
@Getter
@Setter

public class Revue  extends Ressource{
    private String issn;
}
