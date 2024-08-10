package pro.angelogomez.mss_login.application;

import lombok.AllArgsConstructor;
import pro.angelogomez.mss_login.domain.model.User;
import pro.angelogomez.mss_login.domain.port.IUserRepository;

@AllArgsConstructor
public class RegistrationService {
    private final IUserRepository iUserRepository;

    public User register(User user) {
        return iUserRepository.save(user);
    }
}
