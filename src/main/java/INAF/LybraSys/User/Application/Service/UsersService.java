package INAF.LybraSys.User.Application.Service;

import INAF.LybraSys.User.Api.Dto.UsersRequestDto;
import INAF.LybraSys.User.Api.Dto.UsersResponseDto;


import java.util.List;


public interface UsersService {
    public UsersResponseDto createUsers(UsersRequestDto usersRequestDto);

    public List<UsersResponseDto> getUsers();

    public UsersResponseDto updateUser(int idUser,UsersRequestDto usersRequestDto );

    public boolean deleteUsers(int idUser);
}
