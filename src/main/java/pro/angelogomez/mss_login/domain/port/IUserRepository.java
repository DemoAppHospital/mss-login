package pro.angelogomez.mss_login.domain.port;

import pro.angelogomez.mss_login.domain.model.User;

public interface IUserRepository {
    User save(User user);
    Iterable<User> findAll();
    User findByEmail(String email);
    User findById(Integer id);

}
