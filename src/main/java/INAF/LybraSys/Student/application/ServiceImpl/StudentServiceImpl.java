package INAF.LybraSys.Student.application.ServiceImpl;

import INAF.LybraSys.Emprunt.infrastructure.EmpruntRepository;
import INAF.LybraSys.Student.Infrastructure.StudentRepository;
import INAF.LybraSys.Student.api.Dto.StudentRequestDto;
import INAF.LybraSys.Student.api.Dto.StudentResponseDto;
import INAF.LybraSys.Student.application.Service.StudentService;
import INAF.LybraSys.User.Infrastructure.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@Transactional

public class StudentServiceImpl implements StudentService {

    private  final StudentRepository studentRepository;
    private final UsersRepository usersRepository;
    private final EmpruntRepository empruntRepository;

    public StudentServiceImpl(StudentRepository studentRepository, UsersRepository usersRepository, EmpruntRepository empruntRepository) {
        this.studentRepository = studentRepository;
        this.usersRepository = usersRepository;
        this.empruntRepository = empruntRepository;
    }

    @Override
    public StudentResponseDto createStudent(StudentRequestDto studentRequestDto) {
        return null;
    }

    @Override
    public List<StudentResponseDto> getStudent(int id) {
        return List.of();
    }

    @Override
    public StudentResponseDto updateStudent(int id, StudentRequestDto studentRequestDto) {
        return null;
    }

    @Override
    public boolean deleteStudent(int id) {
        return false;
    }
}
