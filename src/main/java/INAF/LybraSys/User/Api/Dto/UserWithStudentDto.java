package INAF.LybraSys.User.Api.Dto;

import INAF.LybraSys.Student.api.Dto.StudentResponseDto;

import java.util.List;

public record UserWithStudentDto(
        int id,
        String username,
        String email,
        String role,
        List<StudentResponseDto> Student

) {
}
