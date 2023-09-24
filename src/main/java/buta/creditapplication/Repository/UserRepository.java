package buta.creditapplication.Repository;

import buta.creditapplication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User getUserByFin(String fin);
    User getUserByPassword(String password);
}
