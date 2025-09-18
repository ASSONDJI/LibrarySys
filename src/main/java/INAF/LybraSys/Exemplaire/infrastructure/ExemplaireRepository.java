package INAF.LybraSys.Exemplaire.infrastructure;

import INAF.LybraSys.Exemplaire.domain.ExemplaireModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExemplaireRepository extends JpaRepository<ExemplaireModel, Integer> {
}
