package buta.creditapplication.Repository;

import buta.creditapplication.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {
    User getUserByFin(String fin);
    User getUserByPassword(String password);
    @Transactional
    @Modifying
    @Query("update User u set u.password = :password" +
            " where u.fin = :fin")
    void updatePassword(String fin, String password);
}
