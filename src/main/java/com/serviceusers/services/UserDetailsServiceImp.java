package com.serviceusers.services;

import com.serviceusers.dto.UserDTO;
import com.serviceusers.entities.User;
import lombok.RequiredArgsConstructor;
import com.serviceusers.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImp implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("UserName "+username+" not found"));
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public User editUserById(Long id, UserDTO userDTO){
        User user = userRepository.findById(id).orElseThrow();

        if (userDTO.getFirstName() != null) user.setFirstName(userDTO.getFirstName());
        if (userDTO.getLastName() != null) user.setLastName(userDTO.getLastName());
        if (userDTO.getPhoneNumber() != null) user.setPhoneNumber(userDTO.getPhoneNumber());
        if (userDTO.getRole() != null) user.setRole(userDTO.getRole());

        return userRepository.save(user);
    }

    // Méthode pour obtenir le total des utilisateurs
    public long getTotalUsers() {
        return userRepository.count(); // Utilise la méthode count() de JpaRepository
    }

}
