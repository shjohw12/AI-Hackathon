package real.world.domain.repository;

import java.util.Optional;
import org.springframework.data.repository.Repository;
import real.world.domain.entity.User;

public interface UserRepository extends Repository<User, Long> {

    User save(User user);

    Optional<User> findById(Long id);

    boolean existsByUsername(String username);

}
