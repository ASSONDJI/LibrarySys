package INAF.LybraSys.Exemplaire.application.ServiceImpl;

import INAF.LybraSys.Exemplaire.api.Dto.ExemplaireRequestDto;
import INAF.LybraSys.Exemplaire.api.Dto.ExemplaireResponseDto;
import INAF.LybraSys.Exemplaire.application.Service.ExemplaireService;
import INAF.LybraSys.Exemplaire.domain.ExemplaireModel;
import INAF.LybraSys.Exemplaire.infrastructure.ExemplaireRepository;
import INAF.LybraSys.Ressource.Domain.RessourceModel;
import INAF.LybraSys.Ressource.Infrastructure.RessourceRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional

public class ExemplaireServiceImpl implements ExemplaireService {

    private final ExemplaireRepository exemplaireRepository;
    private final RessourceRepository ressourceRepository;

    public ExemplaireServiceImpl(ExemplaireRepository exemplaireRepository, RessourceRepository ressourceRepository) {
        this.exemplaireRepository = exemplaireRepository;
        this.ressourceRepository = ressourceRepository;
    }

    @Override
    public ExemplaireResponseDto createExemplaire(ExemplaireRequestDto requestDto) {

        RessourceModel ressource = ressourceRepository.findById(requestDto.ressourceId())
                .orElseThrow(() -> new RuntimeException("Ressource introuvable"));


        ExemplaireModel exemplaire = new ExemplaireModel();
        exemplaire.setCodeExemplaire(requestDto.codeExemplaire());
        exemplaire.setEtat(requestDto.etat());
        exemplaire.setStatut(requestDto.statut());
        exemplaire.setRessource(ressource);


        ExemplaireModel saved = exemplaireRepository.save(exemplaire);

        return new ExemplaireResponseDto(
                saved.getIdExemplaire(),
                saved.getCodeExemplaire(),
                saved.getEtat(),
                saved.getStatut(),
                saved.getRessource().getTitre()
        );
    }

    @Override
    public List<ExemplaireResponseDto> getExemplaire() {
        return exemplaireRepository.findAll()
                .stream()
                .map(ex -> new ExemplaireResponseDto(
                        ex.getIdExemplaire(),
                        ex.getCodeExemplaire(),
                        ex.getEtat(),
                        ex.getStatut(),
                        ex.getRessource().getTitre()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public ExemplaireResponseDto updateExemplaire(int id, ExemplaireRequestDto exemplaireRequestDto) {
        ExemplaireModel exemplaire = exemplaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exemplaire introuvable"));


        exemplaire.setCodeExemplaire(exemplaireRequestDto.codeExemplaire());
        exemplaire.setEtat(exemplaireRequestDto.etat());
        exemplaire.setStatut(exemplaireRequestDto.statut());

        if (exemplaireRequestDto.ressourceId() != null) {
            RessourceModel ressource = ressourceRepository.findById(exemplaireRequestDto.ressourceId())
                    .orElseThrow(() -> new RuntimeException("Ressource introuvable"));
            exemplaire.setRessource(ressource);
        }

        ExemplaireModel updated = exemplaireRepository.save(exemplaire);

        return new ExemplaireResponseDto(
                updated.getIdExemplaire(),
                updated.getCodeExemplaire(),
                updated.getEtat(),
                updated.getStatut(),
                updated.getRessource().getTitre()
        );
    }




    @Override
    public boolean deleteExemplaire(int id) {
        ExemplaireModel exemplaire = exemplaireRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exemplaire introuvable"));
        exemplaireRepository.delete(exemplaire);
        return true;
    }
}
