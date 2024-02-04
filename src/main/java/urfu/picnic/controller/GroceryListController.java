package urfu.picnic.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import urfu.picnic.entity.GroceryList;
import urfu.picnic.service.GroceryListService;

import java.util.List;

@Getter
@Setter
@RestController
@RequestMapping("/api/groceryList")
public class GroceryListController {


    private final GroceryListService groceryListService;

    public GroceryListController(GroceryListService groceryListService) {
        this.groceryListService = groceryListService;
    }


    @GetMapping
    public List getAllGroceryList() {
        return groceryListService.getAllGroceryList();
    }

    @GetMapping("/{id}")
    public GroceryList getGroceryListById(@PathVariable(value = "id") Long groceryListId) {
        return groceryListService.getgroceryListById(groceryListId);
    }

    @PostMapping
    public GroceryList createGroceryList(@RequestBody GroceryList groceryList) {
        return groceryListService.createGroceryList(groceryList);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateGroceryList(@PathVariable(value = "id") Long groceryListId, @RequestBody GroceryList groceryListDetails) {
        GroceryList updatedGroceryList = groceryListService.updateGroceryList(groceryListId, groceryListDetails);
        return ResponseEntity.ok(updatedGroceryList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteGroceryList(@PathVariable(value = "id") Long groceryListId) {
        groceryListService.deleteGroceryList(groceryListId);
        return ResponseEntity.ok().build();
    }
}
