package INAF.LybraSys.Emprunt.application.ServiceImpl;

import INAF.LybraSys.Emprunt.api.Dto.EmpruntRequestDto;
import INAF.LybraSys.Emprunt.api.Dto.EmpruntResponseDto;
import INAF.LybraSys.Emprunt.application.Service.EmpruntService;
import INAF.LybraSys.Emprunt.infrastructure.EmpruntRepository;

import java.util.List;

public class EmpruntServiceImpl implements EmpruntService {
    private final EmpruntRepository empruntRepository;

    public EmpruntServiceImpl(EmpruntRepository empruntRepository) {
        this.empruntRepository = empruntRepository;
    }

    @Override
    public EmpruntResponseDto createEmprunt(EmpruntRequestDto empruntRequestDto) {
        return null;
    }

    @Override
    public List<EmpruntResponseDto> getEmprunt() {
        return List.of();
    }

    @Override
    public EmpruntResponseDto updateEmprunt(int id, EmpruntRequestDto empruntRequestDto) {
        return null;
    }

    @Override
    public boolean deleteEmprunt(int id) {
        return false;
    }
}
