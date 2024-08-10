package pro.angelogomez.mss_login.infraestructure.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pro.angelogomez.mss_login.application.UserService;
import pro.angelogomez.mss_login.domain.model.User;

@Service
@Slf4j
@AllArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("Email del intento de logueo: {}", username);
        log.info("Password encrypted obvio bro nmms: {}", userService.findByEmail(username).getPassword());
        User user = userService.findByEmail(username);
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getEmail())
                .password(user.getPassword())
                .roles(user.getUserType().name())
                .build();
    }

}
