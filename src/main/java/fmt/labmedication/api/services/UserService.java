package fmt.labmedication.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fmt.labmedication.api.entitites.UserEntity;
import fmt.labmedication.api.repositories.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity registerUser(UserEntity user) {
        return userRepository.save(user);
    }

    public UserEntity updateUser(UserEntity updatedUser) {
        Optional<UserEntity> optionalUser = userRepository.findById(updatedUser.getId());
        if (optionalUser.isEmpty())
            return null;
        updatedUser.setPassword(optionalUser.get().getPassword());
        return userRepository.save(updatedUser);
    }
}
