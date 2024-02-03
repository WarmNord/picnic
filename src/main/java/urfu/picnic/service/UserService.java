package urfu.picnic.service;

import urfu.picnic.dto.UserDto;
import urfu.picnic.entity.User;

import java.util.List;

public interface UserService {

    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
