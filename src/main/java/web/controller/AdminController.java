package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping
public class AdminController {
    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    @GetMapping(value = "/admin")
    public String allUsers(ModelMap model, Principal principal) {
        model.addAttribute("listUsers", userService.listUser());
        model.addAttribute("userThis", userService.loadUserByUsername(principal.getName()));
        model.addAttribute("roles",roleService.getListRole());
        if (!model.containsAttribute("newUserAdd")) {
            model.addAttribute("newUserAdd", new User());}
        return "users";
    }



    @PostMapping("/newUser")
    public String createUser(@ModelAttribute("user") User user,@ModelAttribute("roles") String [] roles) {
        Set<Role> rolesS = roleService.getSetRoles(roles);
        user.setUserRoles(rolesS);
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PostMapping(value = "/{id}/update")
    public String postEditUser(@ModelAttribute("user") User user,@ModelAttribute("roles") String [] roles) {
        Set<Role> rolesS = roleService.getSetRoles(roles);
        user.setUserRoles(rolesS);
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/admin";
    }

}

