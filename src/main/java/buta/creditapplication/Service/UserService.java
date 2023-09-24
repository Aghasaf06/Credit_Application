package buta.creditapplication.Service;

import buta.creditapplication.Entity.User;
import buta.creditapplication.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

    public User getByFin(String fin) {
        return userRepository.getUserByFin(fin);
    }

    public Boolean loginMyAccount(String fin, String password) {
        return userRepository.getUserByFin(fin).getId().equals(userRepository.getUserByPassword(password).getId());
    }
}
