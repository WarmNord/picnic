package urfu.picnic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urfu.picnic.dto.GroceryListDto;
import urfu.picnic.entity.GroceryList;
import urfu.picnic.repository.GroceryListRepository;

@Service
public class GroceryListServiceImpl implements GroceryListService {

    private GroceryListRepository groceryListRepository;

    @Autowired
    public GroceryListServiceImpl(GroceryListRepository groceryListRepository) {
        this.groceryListRepository = groceryListRepository;
    }


    public GroceryList getCategory(int id) throws Throwable {
        return (GroceryList) groceryListRepository.findByListId(id)
                .orElseThrow(() -> new RuntimeException("List Not Found"));
    }

    public GroceryList saveCategory(GroceryList groceryList) {
        return groceryListRepository.save(groceryList);
    }

    public void deleteCategory(int id) {
        groceryListRepository.deleteByListId(id);
    }

    @Override
    public void addNewList(GroceryListDto groceryListDto) {

    }
}
