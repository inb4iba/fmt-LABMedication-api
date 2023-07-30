package fmt.labmedication.api.dtos.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordDTO {
    @NotBlank
    @JsonProperty("senha_anterior")
    String oldPassword;

    @NotBlank
    @Size(min = 8)
    @JsonProperty("senha_nova")
    String newPassword;
}
