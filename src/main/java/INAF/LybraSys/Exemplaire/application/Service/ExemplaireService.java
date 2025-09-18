package INAF.LybraSys.Exemplaire.application.Service;

import INAF.LybraSys.Exemplaire.api.Dto.ExemplaireRequestDto;
import INAF.LybraSys.Exemplaire.api.Dto.ExemplaireResponseDto;

import java.util.List;

public interface ExemplaireService {

    public ExemplaireResponseDto createExemplaire(ExemplaireRequestDto exemplaireRequestDto);

    List<ExemplaireResponseDto> getExemplaire();

    public ExemplaireResponseDto updateExemplaire(int id, ExemplaireRequestDto exemplaireRequestDto);

    public boolean deleteExemplaire(int id);
}
