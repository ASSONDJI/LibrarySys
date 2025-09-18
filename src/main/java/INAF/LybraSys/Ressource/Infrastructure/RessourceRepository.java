package INAF.LybraSys.Ressource.Infrastructure;

import INAF.LybraSys.Ressource.Domain.RessourceModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RessourceRepository extends JpaRepository<RessourceModel, Integer> {
}
