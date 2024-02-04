package urfu.picnic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urfu.picnic.entity.UserLists;
import urfu.picnic.repository.UserListsRepository;

import java.util.List;

@Service
public class UserListsServiceImpl implements UserListsService {

    private UserListsRepository userListsRepository;

    @Autowired
    public void UserListsService(UserListsRepository userListsRepository) {
        this.userListsRepository = userListsRepository;
    }

    @Override
    public List getAllUsers() {
        return userListsRepository.findAll();
    }

    public UserLists getUserListById(Long userListId) {
        return userListsRepository.findUserListsByUserId(userListId);
    }

    @Override
    public UserLists createUserList(UserLists userList) {
        return userListsRepository.save(userList);
    }

    @Override
    public UserLists updateUser(Long userId, UserLists userListsDetails) {
        UserLists existingUserList = userListsRepository.findById(Math.toIntExact(userId))
                .orElseThrow(() -> new RuntimeException("User not found"));

        existingUserList.setTeam(userListsDetails.getTeam());
        existingUserList.setUserId(userListsDetails.getUserId());

        UserLists updatedUserList = userListsRepository.save(existingUserList);

        return updatedUserList;
    }

    @Override
    public void deleteUserList(Long userListId) {
        UserLists existingUserList = userListsRepository.findById(Math.toIntExact(userListId))
                .orElseThrow(() -> new RuntimeException("User not found"));
        userListsRepository.delete(existingUserList);
    }
}
