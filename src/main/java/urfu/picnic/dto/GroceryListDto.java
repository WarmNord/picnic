package urfu.picnic.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroceryListDto {

    private Long listId;
    private String listName;
    private String productName;
    private int categoryId;
    private int weight;
    private int liters;
    private int quantity;
}
