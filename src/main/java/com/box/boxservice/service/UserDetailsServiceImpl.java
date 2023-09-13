package com.box.boxservice.service;

import java.util.Optional;
import com.box.boxservice.entity.Usuario;
import com.box.boxservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuario = userRepository.findOneByEmail(email);

        if (!usuario.isPresent()) {
            throw new UsernameNotFoundException(email);
        }

        return org.springframework.security.core.userdetails.User
                .withUsername(email)
                .password(usuario.get().getPassword())
                .roles(usuario.get().getRol())
                .build();
    }
}
