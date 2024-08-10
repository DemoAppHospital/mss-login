package pro.angelogomez.mss_login.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pro.angelogomez.mss_login.application.RegistrationService;
import pro.angelogomez.mss_login.application.UserService;
import pro.angelogomez.mss_login.domain.port.IUserRepository;

@Configuration
public class BeanConfiguration {
    @Bean
    public UserService userService(IUserRepository iUserRepository){
        return new UserService(iUserRepository);
    }
    @Bean
    public RegistrationService registrationService(IUserRepository iUserRepository){
        return new RegistrationService(iUserRepository);
    }
}
