package INAF.LybraSys.Student.api.Dto;

public record StudentResponseDto(
        Integer idStudent,
        String name,
        String firstname,
        String email,
        String phoneNumber,
        String faculty,
        String department,
        String major
) {
}
