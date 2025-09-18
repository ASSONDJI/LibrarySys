package INAF.LybraSys.Emprunt.api.Dto;

import java.util.Date;
import java.util.List;

public record EmpruntRequestDto(
        int userId,
        int exemplaireId,
        Date dateEmprunt,
        Date dateRetourPrevu,
        Date dateRetourEffectif,
        String statut
) {
}
