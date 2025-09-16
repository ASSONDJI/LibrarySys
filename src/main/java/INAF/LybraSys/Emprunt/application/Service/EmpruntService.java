package INAF.LybraSys.Emprunt.application.Service;

import INAF.LybraSys.Emprunt.api.Dto.EmpruntRequestDto;
import INAF.LybraSys.Emprunt.api.Dto.EmpruntResponseDto;

import java.util.List;

public interface EmpruntService {

    public EmpruntResponseDto createEmprunt(EmpruntRequestDto empruntRequestDto);

    List<EmpruntResponseDto> getEmprunt();

    public EmpruntResponseDto updateEmprunt(int id, EmpruntRequestDto empruntRequestDto);

    public boolean deleteEmprunt(int id);
}
