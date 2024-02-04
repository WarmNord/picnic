package urfu.picnic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urfu.picnic.entity.UserLists;
import urfu.picnic.service.UserListsService;

import java.util.List;

@RestController
@RequestMapping("/api/userList")
public class UserListsController {

    private final UserListsService userListsService;

    @Autowired
    public UserListsController(UserListsService userListsService) {
        this.userListsService = userListsService;
    }

    @GetMapping
    public List getAllUsers() {
        return userListsService.getAllUsers();
    }

    @GetMapping("/{id}")
    public UserLists getUserListById(@PathVariable(value = "id") Long userListId) {
        return userListsService.getUserListById(userListId);
    }

    @PostMapping
    public UserLists createUserList(@RequestBody UserLists user) {
        return userListsService.createUserList(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUserList(@PathVariable(value = "id") Long userId, @RequestBody UserLists userListsDetails) {
        UserLists userLists = userListsService.updateUser(userId, userListsDetails);
        return ResponseEntity.ok(userLists);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserList(@PathVariable(value = "id") Long userListId) {
        userListsService.deleteUserList(userListId);
        return ResponseEntity.ok().build();
    }
}