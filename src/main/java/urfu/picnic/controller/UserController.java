package urfu.picnic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import urfu.picnic.dto.UserDto;
import urfu.picnic.entity.User;
import urfu.picnic.service.UserServiceImpl;

@RestController
public class UserController {
    @Autowired
    private UserServiceImpl userService;


}
