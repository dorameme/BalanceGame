package kimyunsoo.balancegame.user.repository;

import kimyunsoo.balancegame.user.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long>
{
    User findByName(String name);

}

