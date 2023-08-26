package real.world.domain.dto.request;


import com.fasterxml.jackson.annotation.JsonRootName;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonRootName("user")
@NoArgsConstructor
public class LoginRequest {

    @NotBlank
    private String email;

    @NotBlank
    private String password;
}
