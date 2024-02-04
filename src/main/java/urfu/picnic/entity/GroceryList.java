package urfu.picnic.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "list")
public class GroceryList { // Не забыть поправить диаграмму и изменить там имя

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listId;

    @Column(length = 50, nullable = false)
    private String listName;

    @Column(length = 50, nullable = false)
    private String productName;

    @Column(nullable = false)
    private Long categoryId;

    private Long weight;

    private Long liters;

    private Long quantity;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "categoryId", nullable = false)
    private Category category;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "listId")
    private UserLists userLists;
}
