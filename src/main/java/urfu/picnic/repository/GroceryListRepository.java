package urfu.picnic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urfu.picnic.entity.GroceryList;

public interface GroceryListRepository extends JpaRepository<GroceryList, Integer> {
}
