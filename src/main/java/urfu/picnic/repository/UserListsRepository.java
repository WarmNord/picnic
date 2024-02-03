package urfu.picnic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urfu.picnic.entity.UserLists;

public interface UserListsRepository extends JpaRepository<UserLists, Integer> {

    UserLists findUserListsByListId(int listId);

}
