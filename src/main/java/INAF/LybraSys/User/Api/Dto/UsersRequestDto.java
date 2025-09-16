package INAF.LybraSys.User.Api.Dto;

import java.util.List;

public record UsersRequestDto(
        String name,
        String firstname,
        Integer roleId,
        List<Integer> Usersid
) {

}
