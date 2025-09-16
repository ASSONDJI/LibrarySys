package INAF.LybraSys.User.Infrastructure;

import INAF.LybraSys.User.Domain.UsersModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersModel, Integer> {
}
