package INAF.LybraSys.Emprunt.api.Dto;

import java.util.List;

public record EmpruntRequestDto(
        String name,
        List<Integer> Empruntid
) {
}
