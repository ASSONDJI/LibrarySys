package INAF.LybraSys.Ressource.Application.ServiceImpl;

import INAF.LybraSys.Ressource.Api.Dto.RessourceRequestDto;
import INAF.LybraSys.Ressource.Api.Dto.RessourceResponseDto;
import INAF.LybraSys.Ressource.Application.Service.RessourceService;
import INAF.LybraSys.Ressource.Domain.RessourceModel;
import INAF.LybraSys.Ressource.Infrastructure.RessourceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class RessourceServiceImpl implements RessourceService {

    private final RessourceRepository ressourceRepository;

    public RessourceServiceImpl(RessourceRepository ressourceRepository) {
        this.ressourceRepository = ressourceRepository;
    }

    @Override
    public RessourceResponseDto createRessource(RessourceRequestDto requestDto) {
        RessourceModel ressource = new RessourceModel();
        ressource.setTitre(requestDto.titre());
        ressource.setAuteur(requestDto.auteur());
        ressource.setType(requestDto.type());

        RessourceModel saved = ressourceRepository.save(ressource);

        return new RessourceResponseDto((int) saved.getIdRessource(), saved.getTitre(), saved.getAuteur(), saved.getType());
    }

    @Override
    public List<RessourceResponseDto> getRessource() {
        return ressourceRepository.findAll().stream()
                .map(r -> new RessourceResponseDto((int) r.getIdRessource(), r.getTitre(), r.getAuteur(), r.getType()))
                .collect(Collectors.toList());

    }


    @Override
    public RessourceResponseDto updateRessource(int id, RessourceRequestDto ressourceRequestDto) {
            RessourceModel ressource = ressourceRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Ressource introuvable"));

            ressource.setTitre(ressourceRequestDto.titre());
            ressource.setAuteur(ressourceRequestDto.auteur());
            ressource.setType(ressourceRequestDto.type());

            RessourceModel updated = ressourceRepository.save(ressource);

            return new RessourceResponseDto((int) updated.getIdRessource(), updated.getTitre(), updated.getAuteur(), updated.getType());

    }

    @Override
    public boolean deleteRessource(int id) {
            if (!ressourceRepository.existsById(id)) {
                return false;
            }
            ressourceRepository.deleteById(id);
            return true;

    }
}
