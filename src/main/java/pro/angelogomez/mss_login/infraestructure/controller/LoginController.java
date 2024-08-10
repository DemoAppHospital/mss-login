package pro.angelogomez.mss_login.infraestructure.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.angelogomez.mss_login.application.UserService;
import pro.angelogomez.mss_login.domain.model.User;
import pro.angelogomez.mss_login.infraestructure.dto.JWTClient;
import pro.angelogomez.mss_login.infraestructure.dto.UserDTO;
import pro.angelogomez.mss_login.infraestructure.jwt.JWTGenerator;

@RestController
@RequestMapping("/v1")
@AllArgsConstructor
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final JWTGenerator jwtGenerator;
    private final UserService userService;

    @PostMapping("/login") // http://localhost:8085/api/v1/security/login
    public ResponseEntity<JWTClient> login(@RequestBody UserDTO userDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userDTO.username(), userDTO.password())
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        User user = userService.findByEmail(userDTO.username());
        String token = jwtGenerator.getToken(userDTO.username());
        JWTClient jwtClient = new JWTClient(user.getId(), token, user.getUserType().toString(), user.getFirstName());

        return new ResponseEntity<>(jwtClient, HttpStatus.OK);
    }
}
