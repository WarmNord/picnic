package urfu.picnic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urfu.picnic.dto.UserListsDto;
import urfu.picnic.entity.UserLists;
import urfu.picnic.repository.UserListsRepository;

@Service
public class UserListsServiceImpl implements UserListsService {

    private UserListsRepository userListsRepository;

    @Autowired
    public void UserListsService(UserListsRepository userListsRepository) {
        this.userListsRepository = userListsRepository;
    }

    public UserLists getUserList(int id) throws Throwable {
        return (UserLists) userListsRepository.findByUserId(id)
                .orElseThrow(() -> new RuntimeException("User list Not Found"));
    }

    public UserLists saveTeam(UserLists userLists) {
        return userListsRepository.save(userLists);
    }

    public void deleteUserLists(int id) {
        userListsRepository.deleteByListId(id);
    }
    @Override
    public void addNewUserList(UserListsDto userListsDto) {

    }
}
