package INAF.LybraSys.Exemplaire.api.Dto;

import INAF.LybraSys.Exemplaire.domain.ExemplaireModel;

import java.util.List;

public record ExemplaireResponseDto(
        int idExemplaire,
        String codeExemplaire,
        String etat,
        String statut,
        String titreRessource
) {
}
