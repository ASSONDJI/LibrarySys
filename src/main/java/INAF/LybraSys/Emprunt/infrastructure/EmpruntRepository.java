package INAF.LybraSys.Emprunt.infrastructure;

import INAF.LybraSys.Emprunt.domain.EmpruntModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpruntRepository extends JpaRepository<EmpruntModel, Integer> {
}
