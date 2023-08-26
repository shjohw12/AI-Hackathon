package real.world.domain.dto.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Getter;
import real.world.domain.entity.User;

@Getter
@JsonRootName(value = "user")
public class RegisterResponse { // ResgiterResponse 보다 UserResponse가 맞을 듯?

    private final String username;

    private final String email;

    private final String bio;

    private final String image;

    private RegisterResponse(String username, String email, String bio, String image) {
        this.username = username;
        this.email = email;
        this.bio = bio;
        this.image = image;
    }

    public static RegisterResponse of(User user) {
        return new RegisterResponse(user.getUsername(), user.getEmail(),
            user.getBio(), user.getImageUrl());
    }

}