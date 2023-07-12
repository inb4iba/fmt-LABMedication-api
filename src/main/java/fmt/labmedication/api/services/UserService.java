package fmt.labmedication.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fmt.labmedication.api.dtos.user.RegisterUserDTO;
import fmt.labmedication.api.dtos.user.ResponseUserDTO;
// import fmt.labmedication.api.entitites.UserEntity;
import fmt.labmedication.api.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public ResponseUserDTO registerUser(RegisterUserDTO user) {
        return null;
    }
}
