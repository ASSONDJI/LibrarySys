package INAF.LybraSys.Role.api.Dto;

import INAF.LybraSys.Role.domain.RoleModel;

import java.util.List;

public record RoleRequestDto(
        String name,
        List<Integer> Roleid
) {
}
