package INAF.LybraSys.Role.api;

import INAF.LybraSys.Role.api.Dto.RoleRequestDto;
import INAF.LybraSys.Role.api.Dto.RoleResponseDto;
import INAF.LybraSys.Role.application.Service.RoleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }


    @PostMapping
    public RoleResponseDto createRole(@RequestBody RoleRequestDto roleRequestDto) {
        return roleService.createRole(roleRequestDto);
    }


    @GetMapping
    public List<RoleResponseDto> getRoles() {
        return roleService.getRole();
    }


    @PutMapping("/{id}")
    public RoleResponseDto updateRole(@PathVariable int id,
                                      @RequestBody RoleRequestDto roleRequestDto) {
        return roleService.updateRole(id, roleRequestDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteRole(@PathVariable int id) {
        boolean deleted = roleService.deleteRole(id);
        return ResponseEntity.ok(deleted);
    }

}
