package INAF.LybraSys.Ressource.Application.Service;

import INAF.LybraSys.Ressource.Api.Dto.RessourceRequestDto;
import INAF.LybraSys.Ressource.Api.Dto.RessourceResponseDto;

import java.util.List;

public interface RessourceService {

    public RessourceResponseDto createRessource(RessourceRequestDto ressourceRequestDto);

    List<RessourceResponseDto> getRessource();

    public RessourceResponseDto updateRessource(int id, RessourceRequestDto ressourceRequestDto);

    public boolean deleteRessource(int id);
}
