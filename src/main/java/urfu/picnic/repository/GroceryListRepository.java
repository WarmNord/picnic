package urfu.picnic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urfu.picnic.entity.GroceryList;

import java.util.Optional;

public interface GroceryListRepository extends JpaRepository<GroceryList, Integer> {


    Optional findByListId(int id);

    GroceryList save(GroceryList groceryList);

    void deleteByListId(int id);


}
