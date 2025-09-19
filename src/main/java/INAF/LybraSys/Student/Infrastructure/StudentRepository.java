package INAF.LybraSys.Student.Infrastructure;

import INAF.LybraSys.Student.Domain.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentModel, Integer> {
}
