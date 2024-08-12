package pro.angelogomez.mss_login.infraestructure.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import pro.angelogomez.mss_login.application.RegistrationService;
import pro.angelogomez.mss_login.application.UserService;
import pro.angelogomez.mss_login.domain.model.User;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
@Slf4j
public class RegistrationController {

    private final RegistrationService registrationService;
    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        log.info("Clave recibida: {}", user.getPassword());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        log.info("Clave encriptada: {}", bCryptPasswordEncoder.encode(user.getPassword()));
        return new ResponseEntity<>(registrationService.register(user), HttpStatus.CREATED);
    }

    @GetMapping("/verification/emails") // http://localhost:8085/api/v1/security/verification/emails
    public ResponseEntity<List<String>> getAllEmails() {
        return new ResponseEntity<>(userService.findAllEmails(), HttpStatus.OK);
    }

}
