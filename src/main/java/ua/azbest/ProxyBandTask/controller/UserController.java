package ua.azbest.ProxyBandTask.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.azbest.ProxyBandTask.model.User;
import ua.azbest.ProxyBandTask.services.UserService;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

//    @GetMapping("/{email}")
//    public User getUser(@PathVariable("email") String email) {
//        return userService.getUserByEmail(email);
//    }

    @PostMapping
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping
    public void deleteUser(@RequestParam("id") String id) {
        userService.deleteUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User user) {
        return userService.updateUser(id, user);
    }
}
