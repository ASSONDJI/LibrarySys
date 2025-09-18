package INAF.LybraSys.Exemplaire.api.Dto;

import java.util.List;

public record ExemplaireRequestDto(
        String codeExemplaire,
        String etat,
        String statut,
        Integer ressourceId

) {
}
