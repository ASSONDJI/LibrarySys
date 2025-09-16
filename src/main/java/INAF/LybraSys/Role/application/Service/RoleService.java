package INAF.LybraSys.Role.application.Service;

import INAF.LybraSys.Role.api.Dto.RoleRequestDto;
import INAF.LybraSys.Role.api.Dto.RoleResponseDto;

import java.util.List;

public interface RoleService {

    public RoleResponseDto createRole(RoleRequestDto roleRequestDto);

    List<RoleResponseDto> getRole();

    public RoleResponseDto updateRole(int id, RoleRequestDto roleRequestDto);

    public boolean deleteRole(int id);
}
