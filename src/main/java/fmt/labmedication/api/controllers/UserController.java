package fmt.labmedication.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fmt.labmedication.api.entitites.UserEntity;

@RestController
@RequestMapping("/usuarios")
public class UserController {

    @PostMapping
    public UserEntity registerUser(UserEntity user) {
        return null;
    }
}
