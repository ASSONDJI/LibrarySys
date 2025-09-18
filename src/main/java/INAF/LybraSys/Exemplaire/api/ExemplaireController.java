package INAF.LybraSys.Exemplaire.api;

import INAF.LybraSys.Exemplaire.api.Dto.ExemplaireRequestDto;
import INAF.LybraSys.Exemplaire.api.Dto.ExemplaireResponseDto;
import INAF.LybraSys.Exemplaire.application.Service.ExemplaireService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/exemplaires")

public class ExemplaireController {

    private final ExemplaireService exemplaireService;

    public ExemplaireController(ExemplaireService exemplaireService) {
        this.exemplaireService = exemplaireService;
    }

    @PostMapping
    public ResponseEntity<ExemplaireResponseDto> createExemplaire(@RequestBody ExemplaireRequestDto exemplaireRequestDto){
        ExemplaireResponseDto created = exemplaireService.createExemplaire(exemplaireRequestDto );
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<ExemplaireResponseDto>> getAllExemplaire(){
        return ResponseEntity.ok(exemplaireService.getExemplaire());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExemplaireResponseDto> updateExemplaire(@PathVariable int id, @RequestBody ExemplaireRequestDto exemplaireRequestDto){
        return  ResponseEntity.ok(exemplaireService.updateExemplaire(id, exemplaireRequestDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteExemplaire(@PathVariable int id){
        boolean deleted = exemplaireService.deleteExemplaire(id);
        return ResponseEntity.ok(deleted);

    }


}
