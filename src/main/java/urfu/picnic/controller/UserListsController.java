package urfu.picnic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urfu.picnic.entity.UserLists;
import urfu.picnic.repository.UserListsRepository;

import java.util.List;

@RestController
@RequestMapping("/api/userList")
public class UserListsController {

    @Autowired
    private UserListsRepository userListRepository;

    @GetMapping
    public List getAllUsers() {
        return userListRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable int id) {
        UserLists userLists = userListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return new ResponseEntity<>(userLists, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity createUser(@RequestBody UserLists userLists) {
        UserLists savedUserLists = userListRepository.save(userLists);
        return new ResponseEntity<>(savedUserLists, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUserList(@PathVariable int id, @RequestBody UserLists userLists) {
        UserLists existingUserList = userListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUserList.setTeam(userLists.getTeam());
        existingUserList.setUserId(userLists.getUserId());

        UserLists updatedUserList = userListRepository.save(existingUserList);
        return new ResponseEntity<>(updatedUserList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUserList(@PathVariable int id) {
        UserLists existingUserList = userListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        userListRepository.delete(existingUserList);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}