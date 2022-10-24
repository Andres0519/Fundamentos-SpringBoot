package com.fundamentos.springboot.fundamentos.service;

import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private final Log LOG = LogFactory.getLog(UserService.class);
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void saveTrasanctional(List<User> users){

        users.stream()
                .peek(user -> LOG.info("Ususrio insertado" + user))
                .forEach(userRepository::save);

    }

    public List<User> obtenerUsuarios(){

        return userRepository.findAll();

    }

    public User save(User newUser) {

        return userRepository.save(newUser);

    }

    public void eliminar(Long id) {

        userRepository.delete(new User(id));

    }

    public User update(User newUser, Long id) {

        return userRepository.findById(id).map(user -> {

            user.setEmail(newUser.getEmail());
            user.setCumpleaños(newUser.getCumpleaños());
            user.setNombre(newUser.getNombre());
            return userRepository.save(user);

        }).get();
    }
}
