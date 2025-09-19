package INAF.LybraSys.User.Api.Dto;

public record UsersResponseDto(
        int idUser,
        String username,
        String role,
        String email
) {
}
