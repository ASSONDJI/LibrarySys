package INAF.LybraSys.Role.application.ServiceImpl;

import INAF.LybraSys.Role.api.Dto.RoleRequestDto;
import INAF.LybraSys.Role.api.Dto.RoleResponseDto;
import INAF.LybraSys.Role.application.Service.RoleService;
import INAF.LybraSys.Role.domain.RoleModel;
import INAF.LybraSys.Role.infrastructure.RoleRepository;
import INAF.LybraSys.User.Infrastructure.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final UsersRepository usersRepository;


    public RoleServiceImpl(RoleRepository roleRepository, UsersRepository usersRepository) {
        this.roleRepository = roleRepository;
        this.usersRepository = usersRepository;
    }


    @Override
    public RoleResponseDto createRole(RoleRequestDto roleRequestDto) {
        RoleModel role = new RoleModel();
        role.setName(roleRequestDto.name());

        RoleModel savedRole = roleRepository.save(role);

        return new RoleResponseDto(
                savedRole.getIdRole(),
                savedRole.getName()
        );
    }


    @Override
    public List<RoleResponseDto> getRole() {
        List<RoleModel> roles = roleRepository.findAll();

        return roles.stream()
                .map(role -> new RoleResponseDto(
                        role.getIdRole(),
                        role.getName()
                ))
                .toList();
    }


    @Override

    public RoleResponseDto updateRole(int id, RoleRequestDto roleRequestDto) {

        RoleModel existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role introuvable avec id : " + id));

        existingRole.setName(roleRequestDto.name());

        RoleModel updatedRole = roleRepository.save(existingRole);

        return new RoleResponseDto(
                updatedRole.getIdRole(),
                updatedRole.getName()
        );
    }


    @Override
    public boolean deleteRole(int id) {
        RoleModel role = roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Role introuvable"));

        role.getUsers().forEach(user -> user.setRole(null));
        roleRepository.delete(role);

        return true;
    }


}
