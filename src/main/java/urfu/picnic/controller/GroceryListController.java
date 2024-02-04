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

/*    @Autowired
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
    }*/
}
