package urfu.picnic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import urfu.picnic.service.UserService;

@RestController
public class UserController {
    @Autowired
    private UserService userService;


}
