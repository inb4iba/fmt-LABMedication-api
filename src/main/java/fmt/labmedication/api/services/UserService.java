package fmt.labmedication.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import fmt.labmedication.api.dtos.user.PasswordDTO;
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

    public UserEntity updatePassword(Long id, PasswordDTO passwordDto) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));

        if (!oldPasswordMatches(user.getPassword(), passwordDto.getOldPassword()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha inválida!");

        user.setPassword(passwordDto.getNewPassword());
        return userRepository.save(user);
    }

    private boolean oldPasswordMatches(String oldPassword, String passedOldPassword) {
        return oldPassword.equals(passedOldPassword);
    }
}
