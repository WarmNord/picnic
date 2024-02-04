package urfu.picnic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urfu.picnic.entity.UserLists;

import java.util.Optional;

public interface UserListsRepository extends JpaRepository<UserLists, Integer> {

    UserLists findUserListsByUserId(int listId);

    Optional findByUserId(int userId);

    UserLists save(UserLists userLists);

    void deleteByListId(int id);
}
