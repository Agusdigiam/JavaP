package com.box.boxservice.controller;

import com.box.boxservice.dto.AuthenticationDTO;
import com.box.boxservice.dto.TokenDTO;
import com.box.boxservice.service.JwtUtilService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/security")
public class SecurityController {
    private static final Logger logger = LoggerFactory.getLogger(SecurityController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService usuarioDetailsService;

    @Autowired
    private JwtUtilService jwtUtilService;
    @PostMapping("/authenticate")
    public ResponseEntity<TokenDTO> authenticate(@RequestBody AuthenticationDTO authenticationReq) {
        logger.info("Autenticando al usuario {}", authenticationReq.getEmail());

        authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        authenticationReq.getEmail(),
                        authenticationReq.getClave()));

        final UserDetails userDetails = usuarioDetailsService.loadUserByUsername(authenticationReq.getEmail());
        final String jwt = jwtUtilService.generateToken(userDetails);
        return ResponseEntity.ok(new TokenDTO(jwt));
    }
}
