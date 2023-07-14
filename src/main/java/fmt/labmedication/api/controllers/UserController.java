package fmt.labmedication.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fmt.labmedication.api.dtos.user.RegisterUserDTO;
import fmt.labmedication.api.dtos.user.ResponseUserDTO;
import fmt.labmedication.api.dtos.user.UpdateUserDTO;
import fmt.labmedication.api.entitites.UserEntity;
import fmt.labmedication.api.mappers.UserMapper;
import fmt.labmedication.api.services.UserService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper mapper;

    @PostMapping
    public ResponseEntity<ResponseUserDTO> registerUser(@RequestBody @Valid RegisterUserDTO registerUserDto) {
        UserEntity user = mapper.toEntity(registerUserDto);
        ResponseUserDTO responseUserDto = mapper.toDto(userService.registerUser(user));
        return new ResponseEntity<ResponseUserDTO>(responseUserDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseUserDTO> updateUser(@PathVariable("id") Long id,
            @RequestBody @Valid UpdateUserDTO updateUserDto) {
        updateUserDto.setId(id);
        UserEntity user = mapper.toEntity(updateUserDto);
        user = userService.updateUser(user);
        if (user == null)
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        return new ResponseEntity<ResponseUserDTO>(mapper.toDto(user), HttpStatus.OK);
    }
}
