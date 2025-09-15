package INAF.LybraSys.Livre.Domain;

import INAF.LybraSys.Ressource.Domain.Ressource;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "livre")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class LivreModel  extends Ressource {
    private String isbn;

}
