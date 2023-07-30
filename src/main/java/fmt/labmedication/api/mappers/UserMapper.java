package fmt.labmedication.api.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fmt.labmedication.api.dtos.user.RegisterUserDTO;
import fmt.labmedication.api.dtos.user.ResponseUserDTO;
import fmt.labmedication.api.dtos.user.UpdateUserDTO;
import fmt.labmedication.api.entitites.UserEntity;

@Component
public class UserMapper {

    @Autowired
    private ModelMapper mapper;

    public ResponseUserDTO toDto(UserEntity user) {
        ResponseUserDTO responseUserDTO = mapper.map(user, ResponseUserDTO.class);
        return responseUserDTO;
    }

    public UserEntity toEntity(RegisterUserDTO userDto) {
        UserEntity user = mapper.map(userDto, UserEntity.class);
        return user;
    }

    public UserEntity toEntity(UpdateUserDTO userDto) {
        UserEntity user = mapper.map(userDto, UserEntity.class);
        return user;
    }
}
