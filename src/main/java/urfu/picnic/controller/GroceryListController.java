package urfu.picnic.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urfu.picnic.entity.GroceryList;
import urfu.picnic.repository.GroceryListRepository;

import java.util.List;

@Getter
@Setter
@RestController
@RequestMapping("/api/groceryList")
public class GroceryListController {

    @Autowired
    private GroceryListRepository groceryListRepository;

    @GetMapping
    public List getAllGroceryList() {
        return groceryListRepository.findAll();
    }

    @GetMapping("/{id}")
    public GroceryList getCategory(@PathVariable int id) {
        return groceryListRepository.findById(id).orElseThrow(() -> new RuntimeException("List not found"));
    }

    @PostMapping("/create")
    public ResponseEntity createGroceryList(@RequestBody GroceryList groceryList) {
        GroceryList savedGroceryList = groceryListRepository.save(groceryList);
        return new ResponseEntity<>(savedGroceryList, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateGroceryList(@PathVariable int id, @RequestBody GroceryList groceryList) throws Throwable {
        GroceryList existingGroceryList = (GroceryList) groceryListRepository.findByListId(id)
                .orElseThrow(() -> new RuntimeException("List not found"));

        existingGroceryList.setListName(groceryList.getListName());
        existingGroceryList.setProductName(groceryList.getProductName());
        existingGroceryList.setCategoryId(groceryList.getCategoryId());
        existingGroceryList.setLiters(groceryList.getLiters());
        existingGroceryList.setWeight(groceryList.getWeight());
        existingGroceryList.setQuantity(groceryList.getQuantity());


        GroceryList updatedGroceryList = groceryListRepository.save(existingGroceryList);
        return new ResponseEntity<>(updatedGroceryList, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable int id) {
        GroceryList groceryList = groceryListRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        groceryListRepository.delete(groceryList);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
