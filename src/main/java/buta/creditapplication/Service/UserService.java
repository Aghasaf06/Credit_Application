package buta.creditapplication.Service;

import buta.creditapplication.Entity.User;
import buta.creditapplication.Repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final IUserRepository iUserRepository;

    public UserService(IUserRepository userRepository) {
        this.iUserRepository = userRepository;
    }

    public void saveUser(User user) {
        iUserRepository.save(user);
    }

    public User getByFin(String fin) {
        return iUserRepository.getUserByFin(fin);
    }

    public Boolean loginMyAccount(String fin, String password) {
        if (iUserRepository.getUserByFin(fin) == null || iUserRepository.getUserByPassword(password) == null) {
            return false;
        } else return iUserRepository.getUserByFin(fin).getId().equals(iUserRepository.getUserByPassword(password).getId());
    }

    public void changePassword(String fin, String password) {
        iUserRepository.updatePassword(fin, password);
    }
}
