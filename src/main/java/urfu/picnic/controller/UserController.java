package urfu.picnic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urfu.picnic.entity.User;
import urfu.picnic.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/api/user/")

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUser(@PathVariable(value = "id") Long userId, @RequestBody User userDetails) {
        User user = userService.updateUser(userId, userDetails);
        return ResponseEntity.ok(user);
    }

}
