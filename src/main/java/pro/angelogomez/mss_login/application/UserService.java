package pro.angelogomez.mss_login.application;

import pro.angelogomez.mss_login.domain.model.User;
import pro.angelogomez.mss_login.domain.port.IUserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private final IUserRepository iUserRepository;
    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }
    public User save(User user) {
        return iUserRepository.save(user);
    }
    public User findByEmail(String email) {
        return iUserRepository.findByEmail(email);
    }
    public User findById(Integer id) {
        return iUserRepository.findById(id);
    }
    public List<String> findAllEmails() {
        List<User> users = new ArrayList<>();
        iUserRepository.findAll().forEach(users::add);
        return users.stream().map(User::getEmail).collect(Collectors.toList());

    }
}
