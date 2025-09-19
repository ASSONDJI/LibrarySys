package INAF.LybraSys.User.Application.ServiceImpl;

import INAF.LybraSys.User.Api.Dto.UsersRequestDto;
import INAF.LybraSys.User.Api.Dto.UsersResponseDto;
import INAF.LybraSys.User.Application.Service.UsersService;
import INAF.LybraSys.User.Domain.UsersModel;
import INAF.LybraSys.User.Infrastructure.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersResponseDto createUsers(UsersRequestDto dto) {
        UsersModel user = toEntity(dto);
        UsersModel savedUser = usersRepository.save(user);
        return toDto(savedUser);
    }

    @Override
    public List<UsersResponseDto> getUsers() {
        return usersRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UsersResponseDto updateUser(int idUser, UsersRequestDto dto) {
        UsersModel user = usersRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("User not found with id " + idUser));

        // Mise à jour de l'utilisateur avec les données du DTO
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setRole(dto.role());

        UsersModel updatedUser = usersRepository.save(user);
        return toDto(updatedUser);
    }

    @Override
    public boolean deleteUsers(int idUser) {
        if (!usersRepository.existsById(idUser)) {
            return false;
        }
        usersRepository.deleteById(idUser);
        return true;
    }

    // Convertit le DTO en entité
    private UsersModel toEntity(UsersRequestDto dto) {
        UsersModel user = new UsersModel();
        user.setUsername(dto.username());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setRole(dto.role());
        return user;
    }

    // Convertit l'entité en DTO
    private UsersResponseDto toDto(UsersModel user) {
        return new UsersResponseDto(
                user.getIdUser(),
                user.getUsername(),
                user.getEmail(),
                user.getRole()
        );
    }
}
