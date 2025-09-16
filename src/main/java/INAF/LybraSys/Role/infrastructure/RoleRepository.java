package INAF.LybraSys.Role.infrastructure;

import INAF.LybraSys.Role.domain.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<RoleModel, Integer> {
}
