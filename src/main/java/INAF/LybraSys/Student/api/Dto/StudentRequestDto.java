package INAF.LybraSys.Student.api.Dto;

public record StudentRequestDto(
        String name,
        String firstname,
        String email,
        String phoneNumber,
        String faculty
) {
}
