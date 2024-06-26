package com.example.MasAirlineBookingManagementSystem.Controller;

import com.example.MasAirlineBookingManagementSystem.Model.User;
import com.example.MasAirlineBookingManagementSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class UserWebController {

    @Autowired
    private UserService userService;

    @GetMapping("/web/users")
    public String getAllUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "listUsers";
    }

    @GetMapping("/web/users/new")
    public String showCreateUserForm(Model model) {
        model.addAttribute("user", new User());
        return "createUser";
    }

    @PostMapping("/usernew")
    public String createUser(@ModelAttribute User user) {
        userService.createUser(user);
        return "redirect:/web/users";
    }

    @GetMapping("/web/users/{id}/edit")
    public String editUserForm(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "editUser";
    }

    @PostMapping("/web/users/{id}/update")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute User updatedUser) {
        userService.updateUser(id, updatedUser);
        return "redirect:/web/users";
    }

    @GetMapping("/web/users/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/web/users";
    }

   /* @GetMapping("/main-page")
    public String showMainPage() {
        return "mainUserPage";
    }*/
}
