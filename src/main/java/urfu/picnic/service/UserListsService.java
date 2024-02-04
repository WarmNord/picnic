package urfu.picnic.service;

import urfu.picnic.entity.UserLists;

import java.util.List;

public interface UserListsService {

    List getAllUsers();

    UserLists getUserListById(Long userListId);

    UserLists createUserList(UserLists userList);

    UserLists updateUser(Long userId, UserLists userListsDetails);

    void deleteUserList(Long userListId);
}
