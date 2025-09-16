package INAF.LybraSys.User.Api;

import INAF.LybraSys.User.Api.Dto.UsersRequestDto;
import INAF.LybraSys.User.Api.Dto.UsersResponseDto;
import INAF.LybraSys.User.Application.Service.UsersService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")

public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping
    public ResponseEntity<UsersResponseDto> createUsers(@RequestBody UsersRequestDto usersRequestDto){
        UsersResponseDto createUsers = usersService.createUsers(usersRequestDto);
        return ResponseEntity.ok(createUsers);
    }

    @GetMapping
    public ResponseEntity<List<UsersResponseDto>> getUsers(){
        return ResponseEntity.ok(usersService.getUsers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsersResponseDto> updateUsers(
            @PathVariable("id") int idUser,
            @RequestBody UsersRequestDto usersRequestDto){
        UsersResponseDto updatedUser = usersService.updateUser(idUser, usersRequestDto);
        return ResponseEntity.ok(updatedUser);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable int id) {
        boolean deleted = usersService.deleteUsers(id);
        return ResponseEntity.ok(deleted);
    }

}
