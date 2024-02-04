package urfu.picnic.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import urfu.picnic.entity.GroceryList;
import urfu.picnic.repository.GroceryListRepository;

import java.util.List;

@Service
public class GroceryListServiceImpl implements GroceryListService {

    private GroceryListRepository groceryListRepository;

    @Autowired
    public GroceryListServiceImpl(GroceryListRepository groceryListRepository) {
        this.groceryListRepository = groceryListRepository;
    }


    @Override
    public List getAllGroceryList() {
        return groceryListRepository.findAll();
    }

    @Override
    public GroceryList getgroceryListById(Long groceryListId) {
        return groceryListRepository.findByListId(groceryListId);
    }

    @Override
    public GroceryList createGroceryList(GroceryList groceryList) {
        return groceryListRepository.save(groceryList);
    }

    @Override
    public GroceryList updateGroceryList(Long groceryListId, GroceryList groceryListDetails) {

        GroceryList existingGroceryList = groceryListRepository.findByListId(groceryListId);

        existingGroceryList.setListName(groceryListDetails.getListName());
        existingGroceryList.setProductName(groceryListDetails.getProductName());
        existingGroceryList.setCategoryId(groceryListDetails.getCategoryId());
        existingGroceryList.setLiters(groceryListDetails.getLiters());
        existingGroceryList.setWeight(groceryListDetails.getWeight());
        existingGroceryList.setQuantity(groceryListDetails.getQuantity());


        GroceryList updatedGroceryList = groceryListRepository.save(existingGroceryList);

        return updatedGroceryList;
    }

    @Override
    public void deleteGroceryList(Long groceryListId) {
        groceryListRepository.deleteByListId(Math.toIntExact(groceryListId));
    }
}
