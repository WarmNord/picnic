package urfu.picnic.service;

import urfu.picnic.entity.GroceryList;

import java.util.List;

public interface GroceryListService {

    List getAllGroceryList();

    GroceryList getgroceryListById(Long groceryListId);

    GroceryList createGroceryList(GroceryList groceryList);

    GroceryList updateGroceryList(Long groceryListId, GroceryList groceryListDetails);

    void deleteGroceryList(Long groceryListId);
}
