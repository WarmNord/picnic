package urfu.picnic.service;

import urfu.picnic.dto.UserListsDto;
import urfu.picnic.entity.UserLists;

import java.util.List;

public interface UserListsService {

    void addNewUserList(UserListsDto userListsDto);

    List getAllUsers();

    UserLists getUserListById(Long userListId);

    UserLists createUserList(UserLists userList);

    UserLists updateUser(Long userId, UserLists userListsDetails);

    void deleteUserList(Long userListId);
}
