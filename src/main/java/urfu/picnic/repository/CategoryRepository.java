package urfu.picnic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import urfu.picnic.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {


    Category findByCategoryId(Long id);

    Category save(Category category);

    void deleteByCategoryId(int id);

}
