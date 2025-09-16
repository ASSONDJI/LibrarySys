package INAF.LybraSys.Emprunt.api.Dto;

import INAF.LybraSys.Emprunt.domain.EmpruntModel;

import java.util.List;

public record EmpruntResponseDto(
        Integer idEmprunt,
        String name,
        List<EmpruntModel> EmpruntList
) {
}
