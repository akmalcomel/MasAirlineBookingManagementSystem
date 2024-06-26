package com.example.MasAirlineBookingManagementSystem.Controller;

import com.example.MasAirlineBookingManagementSystem.Model.User;
import com.example.MasAirlineBookingManagementSystem.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        userService.createUser(user);
        model.addAttribute("success", true);
        return "login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String email, @RequestParam String password, HttpSession session, Model model) {
        User user = userService.getUserByEmailAndPassword(email, password);
        if (user != null) {
            session.setAttribute("user", user);
            return "redirect:/main-page"; // Redirect to home page after successful login
        } else {
            model.addAttribute("error", "Invalid email or password");
            return "login"; // Return to login page with error
        }
    }


    @GetMapping("/logout")
    public String logoutUser(HttpSession session) {
        session.invalidate(); // Invalidate the session
        return "redirect:/users/login"; // Redirect to the login page
    }

    @GetMapping("/admin")
    public String adminUser() {
        return "mainAdminPage";
    }


}
