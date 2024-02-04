package urfu.picnic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urfu.picnic.entity.Category;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Integer> {


    Optional findByCategoryId(int id);

    Category save(Category category);

    void deleteByCategoryId(int id);

}
