package fmt.labmedication.api.services;

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
        if (userRepository.existsUserByCpf(user.getCpf()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um usuário com este CPF!");
        if (userRepository.existsUserByCrm(user.getCrm()))
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe um usuário com este CRM!");
        return userRepository.save(user);
    }

    public UserEntity updateUser(UserEntity updatedUser) {
        UserEntity user = getUserById(updatedUser.getId());
        updatedUser.setPassword(user.getPassword());
        return userRepository.save(updatedUser);
    }

    public UserEntity updatePassword(Long id, PasswordDTO passwordDto) {
        UserEntity user = getUserById(id);
        if (!oldPasswordMatches(user.getPassword(), passwordDto.getOldPassword()))
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha inválida!");
        user.setPassword(passwordDto.getNewPassword());
        return userRepository.save(user);
    }

    private UserEntity getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário não encontrado!"));
    }

    private boolean oldPasswordMatches(String oldPassword, String passedOldPassword) {
        return oldPassword.equals(passedOldPassword);
    }
}
