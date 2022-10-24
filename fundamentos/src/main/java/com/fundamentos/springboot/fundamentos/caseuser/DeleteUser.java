package com.fundamentos.springboot.fundamentos.caseuser;

import com.fundamentos.springboot.fundamentos.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class DeleteUser {

    private UserService userService;

    public DeleteUser(UserService userService) {
        this.userService = userService;
    }

    public void delete(Long id) {

        userService.eliminar(id);

    }
}
