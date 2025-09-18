package INAF.LybraSys.Emprunt.application.ServiceImpl;

import INAF.LybraSys.Emprunt.api.Dto.EmpruntRequestDto;
import INAF.LybraSys.Emprunt.api.Dto.EmpruntResponseDto;
import INAF.LybraSys.Emprunt.application.Service.EmpruntService;
import INAF.LybraSys.Emprunt.domain.EmpruntModel;
import INAF.LybraSys.Emprunt.infrastructure.EmpruntRepository;
import INAF.LybraSys.Exemplaire.domain.ExemplaireModel;
import INAF.LybraSys.Exemplaire.infrastructure.ExemplaireRepository;
import INAF.LybraSys.User.Domain.UsersModel;
import INAF.LybraSys.User.Infrastructure.UsersRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional

public class EmpruntServiceImpl implements EmpruntService {
    private final EmpruntRepository empruntRepository;
    private final ExemplaireRepository exemplaireRepository;
    private final UsersRepository usersRepository;

    public EmpruntServiceImpl(EmpruntRepository empruntRepository, ExemplaireRepository exemplaireRepository, UsersRepository usersRepository) {
        this.empruntRepository = empruntRepository;
        this.exemplaireRepository = exemplaireRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public EmpruntResponseDto createEmprunt(EmpruntRequestDto empruntRequestDto) {
        UsersModel user = usersRepository.findById(empruntRequestDto.userId())
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        ExemplaireModel exemplaire = exemplaireRepository.findById(empruntRequestDto.exemplaireId())
                .orElseThrow(() -> new RuntimeException("Exemplaire introuvable"));

        EmpruntModel emprunt = new EmpruntModel();
        emprunt.setDateEmprunt(empruntRequestDto.dateEmprunt());
        emprunt.setDateRetourPrevu(empruntRequestDto.dateRetourPrevu());
        emprunt.setDateRetourEffectif(empruntRequestDto.dateRetourEffectif());
        emprunt.setStatut(empruntRequestDto.statut());
        emprunt.setUser(user);
        emprunt.setExemplaire(exemplaire);

        EmpruntModel saved = empruntRepository.save(emprunt);

        return toDto(saved);

    }

    @Override
    public List<EmpruntResponseDto> getEmprunt() {
        List<EmpruntModel> emprunts = empruntRepository.findAll();
        return emprunts.stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public EmpruntResponseDto updateEmprunt(int id, EmpruntRequestDto empruntRequestDto) {

        EmpruntModel emprunt = empruntRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(" Emprunt introuvable avec l'ID : " + id));

        UsersModel user = usersRepository.findById(empruntRequestDto.userId())
                .orElseThrow(() -> new RuntimeException(" Utilisateur introuvable avec l'ID : " + empruntRequestDto.userId()));

        ExemplaireModel exemplaire = exemplaireRepository.findById(empruntRequestDto.exemplaireId())
                .orElseThrow(() -> new RuntimeException(" Exemplaire introuvable avec l'ID : " + empruntRequestDto.exemplaireId()));

        emprunt.setDateEmprunt(empruntRequestDto.dateEmprunt());
        emprunt.setDateRetourPrevu(empruntRequestDto.dateRetourPrevu());
        emprunt.setDateRetourEffectif(empruntRequestDto.dateRetourEffectif());
        emprunt.setStatut(empruntRequestDto.statut());
        emprunt.setUser(user);
        emprunt.setExemplaire(exemplaire);

        EmpruntModel updated = empruntRepository.save(emprunt);
        return toDto(updated);

    }

    @Override
    public boolean deleteEmprunt(int id) {
        if (!empruntRepository.existsById(id)) {
            return false;
        }
        empruntRepository.deleteById(id);
        return true;

    }

    private EmpruntResponseDto toDto(EmpruntModel emprunt) {
        return new EmpruntResponseDto(
                emprunt.getIdEmprunt(),
                emprunt.getUser().getName(),
                emprunt.getExemplaire().getCodeExemplaire(),
                emprunt.getDateEmprunt(),
                emprunt.getDateRetourPrevu(),
                emprunt.getDateRetourEffectif(),
                emprunt.getStatut()
        );
    }
}
