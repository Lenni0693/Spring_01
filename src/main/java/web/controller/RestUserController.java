package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.awt.*;
import java.security.Principal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class RestUserController {

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    // Получаем список пользователей
    @GetMapping("/admin")
    public ResponseEntity<List<User>>allUsers(){

        return new ResponseEntity<>(userService.listUser(),HttpStatus.OK);
    }
    // удаляем пользователя
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // обновляем пользователя
    @PutMapping("/admin/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") long id, @RequestBody User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            String error = getErrorsFromBindingResult(bindingResult);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        try {
            String oldPassword = userService.getUserByID(id).getPassword();
            if (oldPassword.equals(user.getPassword())) {
                user.setPassword(oldPassword);
                userService.updateUser(user);
            } else {
                userService.addUser(user);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (UserDataIntegrityViolationException u) {
            throw new UserDataIntegrityViolationException("User with username exist");
        }
    }

    // получаем одного пользователя
    @GetMapping("/admin/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserByID(id));
    }

    // добавляем пользователя
    @PostMapping("/admin")
    public ResponseEntity<String> addUser(@RequestBody User user, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            String error = getErrorsFromBindingResult(bindingResult);
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        try {
            userService.addUser(user);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (UserDataIntegrityViolationException u) {
            throw new UserDataIntegrityViolationException("User with username exist");
        }
    }

    @GetMapping("/user")
    public User getUser(Principal principal){
        return (User) userService.loadUserByUsername(principal.getName());
    }

    private String getErrorsFromBindingResult(BindingResult bindingResult) {
        return bindingResult.getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.joining("; "));
    }
}
