package fmt.labmedication.api.dtos.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordDTO {
    String oldPassword;

    @NotBlank
    @Size(min = 8)
    String newPassword;
}
