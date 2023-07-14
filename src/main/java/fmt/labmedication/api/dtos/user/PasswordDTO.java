package fmt.labmedication.api.dtos.user;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PasswordDTO {
    String oldPassword;

    @NotBlank
    @Size(min = 8)
    String newPassword;
}
