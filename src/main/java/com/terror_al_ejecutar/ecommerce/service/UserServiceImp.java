package com.terror_al_ejecutar.ecommerce.service;

import com.terror_al_ejecutar.ecommerce.models.User;
import com.terror_al_ejecutar.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User usuario) {
        userRepository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
