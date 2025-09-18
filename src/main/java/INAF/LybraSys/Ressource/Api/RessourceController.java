package INAF.LybraSys.Ressource.Api;

import INAF.LybraSys.Ressource.Api.Dto.RessourceRequestDto;
import INAF.LybraSys.Ressource.Api.Dto.RessourceResponseDto;
import INAF.LybraSys.Ressource.Application.Service.RessourceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ressources")

public class RessourceController {

    private final RessourceService ressourceService;

    public RessourceController(RessourceService ressourceService) {
        this.ressourceService = ressourceService;
    }

    @PostMapping
    public ResponseEntity<RessourceResponseDto> createRessource(@RequestBody RessourceRequestDto ressourceRequestDto) {
        return ResponseEntity.ok(ressourceService.createRessource(ressourceRequestDto));
    }

    @GetMapping
    public ResponseEntity<List<RessourceResponseDto>> getAllRessources() {
        return ResponseEntity.ok(ressourceService.getRessource());
    }

    @PutMapping("/{id}")
    public ResponseEntity<RessourceResponseDto> updateRessource(@PathVariable int id, @RequestBody RessourceRequestDto ressourceRequestDto) {
        return ResponseEntity.ok(ressourceService.updateRessource(id, ressourceRequestDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRessource(@PathVariable int id) {
        boolean deleted = ressourceService.deleteRessource(id);
        return ResponseEntity.ok(deleted);
    }


}
