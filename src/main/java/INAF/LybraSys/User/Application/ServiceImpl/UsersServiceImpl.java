package INAF.LybraSys.User.Application.ServiceImpl;

import INAF.LybraSys.Emprunt.infrastructure.EmpruntRepository;
import INAF.LybraSys.Role.domain.RoleModel;
import INAF.LybraSys.Role.infrastructure.RoleRepository;
import INAF.LybraSys.User.Api.Dto.UsersRequestDto;
import INAF.LybraSys.User.Api.Dto.UsersResponseDto;
import INAF.LybraSys.User.Application.Service.UsersService;
import INAF.LybraSys.User.Domain.UsersModel;
import INAF.LybraSys.User.Infrastructure.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional

public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;
    private final RoleRepository roleRepository;



    public UsersServiceImpl(UsersRepository usersRepository, RoleRepository roleRepository) {
        this.usersRepository = usersRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public UsersResponseDto createUsers(UsersRequestDto usersRequestDto) {

        RoleModel role = roleRepository.findById(usersRequestDto.roleId())
                .orElseThrow(() -> new RuntimeException("Role introuvable avec id: " + usersRequestDto.roleId()));

        UsersModel user = new UsersModel();
        user.setName(usersRequestDto.name());
        user.setFirstname(usersRequestDto.firstname());
        user.setRole(role);


        UsersModel savedUser = usersRepository.save(user);


        return new UsersResponseDto(
                savedUser.getIdUser(),
                savedUser.getName(),
                savedUser.getFirstname(),
                savedUser.getRole().getName()
        );
    }


    @Override
    public List<UsersResponseDto> getUsers() {
        List<UsersModel> users = usersRepository.findAll();

        return users.stream()
                .map(user -> new UsersResponseDto(
                        user.getIdUser(),
                        user.getName(),
                        user.getFirstname(),
                        user.getRole() != null ? user.getRole().getName() : null
                )).toList();

    }

    @Override
    public UsersResponseDto updateUser(int idUser, UsersRequestDto usersRequestDto) {

        UsersModel user = usersRepository.findById(idUser)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable avec id: " + idUser));

        user.setName(usersRequestDto.name());
        user.setFirstname(usersRequestDto.firstname());



        UsersModel updatedUser = usersRepository.save(user);

        return new UsersResponseDto(
                updatedUser.getIdUser(),
                updatedUser.getName(),
                updatedUser.getFirstname(),
                updatedUser.getRole().getName()
        );
    }
    @Override
    public boolean deleteUsers(int idUser) {
        if (usersRepository.existsById(idUser)) {
            usersRepository.deleteById(idUser);
            return true;
        } else {
            return false;
        }
    }
}
